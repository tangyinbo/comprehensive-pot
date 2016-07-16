-- Create table
create table T_SEC_USER
(
  user_id            NUMBER not null,
  username           VARCHAR2(20),
  password           VARCHAR2(200),
  mobile_telephone   VARCHAR2(20),
  email              VARCHAR2(50),
  addr               VARCHAR2(20),
  nationality        VARCHAR2(20),
  sex                CHAR(1),
  birthdate          DATE,
  credentials_type   VARCHAR2(32),
  credentials_number VARCHAR2(32),
  status             CHAR(1),
  lv                 NUMBER(2),
  descn              VARCHAR2(500),
  create_by          NUMBER,
  create_date        DATE,
  update_by          NUMBER,
  update_date        DATE,
  version            NUMBER,
  name               VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_SEC_USER.user_id
  is '用户ID';
comment on column T_SEC_USER.username
  is '用户名';
comment on column T_SEC_USER.password
  is '密码';
comment on column T_SEC_USER.mobile_telephone
  is '移动电话';
comment on column T_SEC_USER.email
  is '邮箱';
comment on column T_SEC_USER.addr
  is '地址';
comment on column T_SEC_USER.nationality
  is '国籍';
comment on column T_SEC_USER.sex
  is '性别:1(男),0(女)';
comment on column T_SEC_USER.birthdate
  is '生日';
comment on column T_SEC_USER.credentials_type
  is '证件类型';
comment on column T_SEC_USER.credentials_number
  is '证件编码';
comment on column T_SEC_USER.status
  is '状态';
comment on column T_SEC_USER.lv
  is '等级';
comment on column T_SEC_USER.descn
  is '描述';
comment on column T_SEC_USER.create_by
  is '创建人';
comment on column T_SEC_USER.create_date
  is '创建日期';
comment on column T_SEC_USER.update_by
  is '更新人';
comment on column T_SEC_USER.update_date
  is '更新时间';
comment on column T_SEC_USER.version
  is '版本';
comment on column T_SEC_USER.name
  is '姓名';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SEC_USER
  add constraint T_SEC_USER_PK primary key (USER_ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );



-- Create table
create table T_SEC_ROLE
(
  role_id     NUMBER,
  role_name   VARCHAR2(20),
  role_desc   VARCHAR2(20),
  status      VARCHAR2(20),
  create_by   NUMBER,
  create_date DATE,
  update_by   NUMBER,
  update_date DATE,
  version     NUMBER,
  role_type   VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_SEC_ROLE.role_id
  is '角色ID';
comment on column T_SEC_ROLE.role_name
  is '角色名称';
comment on column T_SEC_ROLE.role_desc
  is '角色描述';
comment on column T_SEC_ROLE.status
  is '状态';
comment on column T_SEC_ROLE.create_by
  is '创建人';
comment on column T_SEC_ROLE.create_date
  is '创建日期';
comment on column T_SEC_ROLE.update_by
  is '最后更新人';
comment on column T_SEC_ROLE.update_date
  is '最后更新时间';
comment on column T_SEC_ROLE.version
  is '版本';
comment on column T_SEC_ROLE.role_type
  is '角色类型';


-- Create table
create table T_SEC_RESC
(
  resc_id        NUMBER,
  resc_name      VARCHAR2(50),
  res_type       VARCHAR2(50),
  res_url        VARCHAR2(200),
  priority       INTEGER,
  status         VARCHAR2(20),
  descn          VARCHAR2(200),
  create_by      NUMBER,
  create_date    DATE,
  update_by      NUMBER,
  update_date    DATE,
  version        NUMBER,
  parent_resc_id NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column T_SEC_RESC.resc_id
  is '资源ID';
comment on column T_SEC_RESC.resc_name
  is '资源名称';
comment on column T_SEC_RESC.res_type
  is '资源类型';
comment on column T_SEC_RESC.res_url
  is '资源URL';
comment on column T_SEC_RESC.priority
  is '优先等级';
comment on column T_SEC_RESC.status
  is '状态';
comment on column T_SEC_RESC.descn
  is '描述';
comment on column T_SEC_RESC.parent_resc_id
  is '父资源ID';

  
-- Create table
create table T_SEC_USER_ROLE
(
  user_id NUMBER,
  role_id NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
  
  -- Create table
create table T_SEC_RESC_ROLE
(
  resc_id NUMBER,
  role_id NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
