package com.liferay.commerce.demo.order.rule.container.contributor;

import com.liferay.commerce.demo.order.rule.container.context.ContainerCOREntryDisplayContext;
import com.liferay.commerce.order.rule.entry.type.COREntryTypeJSPContributor;
import com.liferay.commerce.order.rule.model.COREntry;
import com.liferay.commerce.order.rule.service.COREntryLocalService;
import com.liferay.frontend.taglib.servlet.taglib.util.JSPRenderer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

/**
 * @author Jeff Handa
 */
@Component(
        immediate = true,
        property = "commerce.order.rule.entry.type.jsp.contributor.key=" + ContainerCOREntryTypeJSPContributor.KEY,
        service = COREntryTypeJSPContributor.class
)
public class ContainerCOREntryTypeJSPContributor implements COREntryTypeJSPContributor{

    public static final String KEY ="container-order-rule";

    @Override
    public void render(
            long corEntryId, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws Exception {

        COREntry corEntry = _corEntryLocalService.getCOREntry(corEntryId);
        ContainerCOREntryDisplayContext containerCOREntryDisplayContext = new ContainerCOREntryDisplayContext(corEntry);
        httpServletRequest.setAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT, containerCOREntryDisplayContext);

        _jspRenderer.renderJSP(
                _servletContext, httpServletRequest, httpServletResponse,
                "/container_amount.jsp");
    }

    @Reference
    private JSPRenderer _jspRenderer;

    @Reference(
            target = "(osgi.web.symbolicname=com.liferay.commerce.demo.order.rule.container)"
    )
    private ServletContext _servletContext;

    @Reference
    private COREntryLocalService _corEntryLocalService;
}
