<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.softwerke.journalportlet.MyArticleModel"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
		ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		MyArticleModel myArticleModel = (MyArticleModel) row.getObject();
%>

<liferay-ui:icon-menu>
	
	<portlet:actionURL name="deleteMyArticle" var="deleteMyArticleVar">
		<portlet:param name="myArticleId" value="<%=String.valueOf(myArticleModel.getMyArticleId())%>" />
	</portlet:actionURL>
	
	<liferay-ui:icon   image="delete" message="delete" url="${deleteMyArticleVar}" />

</liferay-ui:icon-menu>
