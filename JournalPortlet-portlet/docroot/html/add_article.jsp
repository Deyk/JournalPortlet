<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.softwerke.journalportlet.util.Constants"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="pageName" value="<%=Constants.VIEW_AUTHOR%>" />
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="back"/>

<portlet:actionURL  var="addArticleActionURL" name="addArticle"> </portlet:actionURL>

<aui:form action="${addArticleActionURL}" method="post" name="<portlet:namespace />fm">
	
	<aui:fieldset>
		<aui:input name="articleName" value="" label="Article Name"/>
		<aui:input type="textarea" name="articleContent" value="" label="Article Content"/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" value="Save Article"/>
	</aui:button-row>
</aui:form>
