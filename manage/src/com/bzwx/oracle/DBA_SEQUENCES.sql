/* 创建各表sequence（备份系统DBA_SEQUENCES表亦可） */

/* 2，先检索索引最大值，再设置 'start with' 创建索引   2011-08-05 02:27 */
create sequence S_BZWX_BUSI_RECIPES_CATEGORY
minvalue 1
maxvalue 999999999999999999999999999
start with 39
increment by 1
nocache;

create sequence S_BZWX_BUSI_RECIPES_INFO
minvalue 1
maxvalue 999999999999999999999999999
start with 32
increment by 1
nocache;

create sequence S_BZWX_BUSI_REC_CATE_MAP
minvalue 1
maxvalue 999999999999999999999999999
start with 25
increment by 1
nocache;





