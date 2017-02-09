<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="pageName" value="back"/>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="back"/>

<portlet:actionURL  var="addReviewActionURL" name="addReview" copyCurrentRenderParameters="true"> </portlet:actionURL>

<aui:form action="${addReviewActionURL}" method="post" name="<portlet:namespace />fm">
	
	<aui:fieldset>
		<aui:input name="reviewName" value="" label="Review Name"/>
		<aui:input name="reviewContent" value="" label="Review Content"/>		
		<aui:input name="articleId" value="" label="Article Id" type="hidden" />
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" value="Save Review"/>
	</aui:button-row>
</aui:form>