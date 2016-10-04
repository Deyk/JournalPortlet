create table journal_MyArticle (
	uuid_ VARCHAR(75) null,
	myArticleId LONG not null primary key,
	myArticleName VARCHAR(75) null,
	myArticleContent VARCHAR(75) null,
	myArticleRefuseComment VARCHAR(75) null,
	myArticleStatus INTEGER,
	isMyArticlePublished BOOLEAN
);

create table journal_MyReview (
	uuid_ VARCHAR(75) null,
	myReviewId LONG not null primary key,
	myReviewDateCreation DATE null,
	myReviewDateModification DATE null,
	myReviewArticleId LONG,
	MyReviewName VARCHAR(75) null,
	MyReviewContent VARCHAR(75) null
);