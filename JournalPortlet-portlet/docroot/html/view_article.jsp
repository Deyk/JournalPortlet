<%@ page import="com.softwerke.journalportlet.util.ArticleStatus"%>
<%@ page import="com.softwerke.journalportlet.models.ArticleModel"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.softwerke.journalportlet.util.Constants"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:renderURL windowState="normal" var="backURL">
	<portlet:param name="pageName" value="<%= Constants.VIEW_COMMON %>" />
</portlet:renderURL>

<liferay-ui:header backURL="${backURL}" title="back" />

<div class="article-view well" >
	<h4>Name</h4>
	<p>${articleParams.articleName}</p>
	<h4>Status</h4>
	<p>${articleParams.displayedStatus}</p>
	<h4>Content</h4>
	<p>${articleParams.articleContent}</p>
</div>

<c:if test="${articleParams.articleStatus == 2}">

<portlet:actionURL  var="updateArticleActionURL" name="updateArticle" copyCurrentRenderParameters="true"> </portlet:actionURL>

<aui:form action="${updateArticleActionURL}" method="post" cssClass="article-view-refused" name="<portlet:namespace />fm">

		<h4>Refuse comment</h4>
		<p class="article-view-refused_color-red">${articleParams.articleRefuseComment}</p>
		<h4>Edit article content</h4>
		
		<aui:fieldset>
			<aui:input name="articleContent" value="" label="Article content"/>
		</aui:fieldset>
		
		<aui:button-row>
			<aui:button type="submit" value="Save Article" />
		</aui:button-row>
		
</aui:form>
</c:if>

<liferay-ui:search-container>
	<liferay-ui:search-container-results results="${reviewArticleIdModel}" />
	<liferay-ui:search-container-row className="com.softwerke.journalportlet.models.ReviewModel" keyProperty="reviewId" modelVar="aReview">
		<liferay-ui:search-container-column-text property="reviewName" name="Review Name" />
		<liferay-ui:search-container-column-text property="reviewContent" name="Review Content" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
