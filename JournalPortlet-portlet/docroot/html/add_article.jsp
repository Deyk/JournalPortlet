<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="pageName" value="something"/>
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="back"/>

<portlet:actionURL  var="addMyArticleActionURL" name="addMyArticle"> </portlet:actionURL>

<aui:form action="${addMyArticleActionURL}" method="post" name="fm">

	<aui:input name="myArticleName" value="" label="Article Name"/>
	<aui:input  name="myArticleContent" value="" label="Article Content"/>
	
	<aui:button-row>
		<aui:button type="submit" value="SaveArticle"/>
	</aui:button-row>
</aui:form>
