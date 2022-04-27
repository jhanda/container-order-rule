<%@ page import="com.liferay.commerce.order.rule.constants.COREntryConstants" %>
<%@ page import="com.liferay.commerce.currency.model.CommerceCurrency" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.commerce.demo.order.rule.container.constants.ContainerCOREntryConstants" %>
<%@ page import="com.liferay.commerce.demo.order.rule.container.context.ContainerCOREntryDisplayContext" %><%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="init.jsp" %>

<%
    ContainerCOREntryDisplayContext containerCOREntryDisplayContext =
            (ContainerCOREntryDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>
<div class="row">
    <div class="col">
        <commerce-ui:panel
                bodyClasses="flex-fill"
                title='<%= LanguageUtil.get(request, "configuration") %>'
        >
            <div class="row">
                <div class="col">
                    <aui:input label="maximum-container-volume-amount" name='<%= "type--settings--" + ContainerCOREntryConstants.TYPE_MAXIMUM_CONTAINER_VOLUME_AMOUNT + "--" %>' required="<%= true %>" type="text" value="<%= containerCOREntryDisplayContext.getMaximumWeightAmount()%>">
                        <aui:validator name="number" />
                    </aui:input>
                </div>

                <div class="col">
                    <aui:input label="maximum-container-weight-amount" name='<%= "type--settings--" + ContainerCOREntryConstants.TYPE_MAXIMUM_CONTAINER_WEIGHT_AMOUNT + "--" %>' required="<%= true %>" type="text" value="<%= containerCOREntryDisplayContext.getMaximumWeightAmount()%>">
                        <aui:validator name="number" />
                    </aui:input>
                </div>

                <div class="col">
                    <aui:input label="packing-efficiency-modifier-amount" name='<%= "type--settings--" + ContainerCOREntryConstants.PACKING_EFFICIENCY_MODIFIER_AMOUNT + "--" %>' required="<%= true %>" type="text" value="<%= containerCOREntryDisplayContext.getPackingEfficiencyModifierAmount()%>">
                        <aui:validator name="number" />
                    </aui:input>
                </div>

            </div>
        </commerce-ui:panel>
    </div>
</div>