<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@page import="com.softwerke.journalportlet.JournalPortlet"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL var="addArticleVar">
	<portlet:param name="pageName" value="<%=JournalPortlet.ADD_ARTICLE %>"/>
</portlet:renderURL>

<a href="${addArticleVar}"><h4>Add Article</h4></a><br/>

<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${myArticleModelList}" />
	<liferay-ui:search-container-row className="com.softwerke.journalportlet.MyArticleModel" keyProperty= "myArticleId" modelVar="aMyArticle">
		<liferay-ui:search-container-column-text property="myArticleName"  name="Article Name" />
		<liferay-ui:search-container-column-text property="myArticleContent"  name="Article Content" />
			<liferay-ui:search-container-column-jsp path="/html/actions.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
