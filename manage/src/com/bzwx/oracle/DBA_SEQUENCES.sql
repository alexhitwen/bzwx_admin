/* 创建各表sequence（备份系统DBA_SEQUENCES表即可） */


/* 2，先检索索引最大值，再设置 'start with' 创建索引 */
create sequence S_BZWX_BUSI_RECIPES_CATEGORY
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;