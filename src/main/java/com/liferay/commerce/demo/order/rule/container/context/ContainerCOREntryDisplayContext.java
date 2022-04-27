package com.liferay.commerce.demo.order.rule.container.context;

import com.liferay.commerce.demo.order.rule.container.constants.ContainerCOREntryConstants;
import com.liferay.commerce.order.rule.model.COREntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.UnicodePropertiesBuilder;

import java.math.BigDecimal;

/**
 * @author Jeff Handa
 */
public class ContainerCOREntryDisplayContext {

    public ContainerCOREntryDisplayContext(COREntry corEntry) {
        _corEntry = corEntry;
    }

    public double getMaximumVolumeAmount(){

        UnicodeProperties typeSettingsUnicodeProperties =
                UnicodePropertiesBuilder.fastLoad(
                        _corEntry.getTypeSettings()
                ).build();

        double maximumVolumeAmount = GetterUtil.getDouble(
                        typeSettingsUnicodeProperties.getProperty(
                                ContainerCOREntryConstants.TYPE_MAXIMUM_CONTAINER_VOLUME_AMOUNT));


        return maximumVolumeAmount;
    }

    public double getMaximumWeightAmount(){

        UnicodeProperties typeSettingsUnicodeProperties =
                UnicodePropertiesBuilder.fastLoad(
                        _corEntry.getTypeSettings()
                ).build();

        double maximumWeightAmount = GetterUtil.getDouble(
                        typeSettingsUnicodeProperties.getProperty(
                                ContainerCOREntryConstants.TYPE_MAXIMUM_CONTAINER_WEIGHT_AMOUNT));


        return maximumWeightAmount;
    }

    public double getPackingEfficiencyModifierAmount(){

        UnicodeProperties typeSettingsUnicodeProperties =
                UnicodePropertiesBuilder.fastLoad(
                        _corEntry.getTypeSettings()
                ).build();

        double packingEfficiencyModifier = GetterUtil.getDouble(
                        typeSettingsUnicodeProperties.getProperty(
                                ContainerCOREntryConstants.PACKING_EFFICIENCY_MODIFIER_AMOUNT));


        return packingEfficiencyModifier;
    }
    private final COREntry _corEntry;
}

