package com.liferay.commerce.demo.order.rule.container.type;

import com.liferay.commerce.demo.order.rule.container.context.ContainerCOREntryDisplayContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.commerce.order.rule.entry.type.COREntryType;
import com.liferay.commerce.order.rule.model.COREntry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Jeff Handa
 */
@Component(
        immediate = true,
        property = {
                "commerce.order.rule.entry.type.key=" + ContainerCOREntryType.KEY,
                "commerce.order.rule.entry.type.order:Integer=1"
        },
        service = COREntryType.class
)
public class ContainerCOREntryType implements COREntryType {

    public static final String KEY = "container-order-rule";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getLabel(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
                "content.Language", locale, getClass());

        return LanguageUtil.get(resourceBundle, "container-order-rule");
    }

    @Override
    public boolean evaluate(COREntry corEntry, CommerceOrder commerceOrder) throws PortalException {
        _log.debug("Evaluating Order ID: " + commerceOrder.getCommerceOrderId());

        ContainerCOREntryDisplayContext containerCOREntryDisplayContext = new ContainerCOREntryDisplayContext(corEntry);
        List<CommerceOrderItem> commerceOrderItems = commerceOrder.getCommerceOrderItems();
        double containerMaxVolume = containerCOREntryDisplayContext.getMaximumVolumeAmount();
        double containerMaxWeight = containerCOREntryDisplayContext.getMaximumWeightAmount();
        double packingEfficiencyModifier = containerCOREntryDisplayContext.getPackingEfficiencyModifierAmount();
        double orderVolume = 0.0;
        double orderWeight = 0.0;
        for (CommerceOrderItem commerceOrderItem: commerceOrderItems){

            double depth = commerceOrderItem.getDepth()/12;
            double height = commerceOrderItem.getHeight()/12;
            double width = commerceOrderItem.getWidth()/12;
            int quantity = commerceOrderItem.getQuantity();
            double productVolume = depth * height * width * packingEfficiencyModifier * quantity;
            orderVolume = orderVolume + productVolume;
            orderWeight = orderWeight + commerceOrderItem.getWeight();
        }

        if (orderVolume > containerMaxVolume){
            _log.debug("Order volume: " + orderVolume + " is greater than container maximum volume " + containerMaxVolume);
            return false;
        }else if(orderWeight > containerMaxWeight) {
            _log.debug("Order Weight: " + orderWeight + " is greater than container maximum weight " + containerMaxWeight);
            return false;
        }else{
            _log.debug("Order volume: " + orderVolume + " is less than container maximum volume " + containerMaxVolume);
            _log.debug("Order weight: " + orderWeight + " is less than container maximum volume " + containerMaxVolume);
            return true;
        }
    }

    @Override
    public String getErrorMessage(COREntry corEntry, CommerceOrder commerceOrder, Locale locale) throws PortalException {
        return "Total order volume must be less than xxxx";
    }

    private static final Log _log = LogFactoryUtil.getLog(
            ContainerCOREntryType.class);


}