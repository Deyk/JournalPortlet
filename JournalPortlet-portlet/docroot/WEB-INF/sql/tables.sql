create table new_perfect_journal_Article (
	uuid_ VARCHAR(75) null,
	articleId LONG not null primary key,
	groupId LONG,
	articleName VARCHAR(75) null,
	articleContent TEXT null,
	articleRefuseComment VARCHAR(75) null,
	articleStatus INTEGER,
	isArticlePublished BOOLEAN,
	userId LONG
);

create table new_perfect_journal_Review (
	uuid_ VARCHAR(75) null,
	reviewId LONG not null primary key,
	groupId LONG,
	reviewName VARCHAR(75) null,
	reviewContent TEXT null,
	articleId LONG,
	userId LONG
);