drop table if exists otc_user_cart;
/*==============================================================*/
/* Table: otc_user_cart                                         */
/*==============================================================*/
create table otc_user_cart
(
    cart_seq             bigint not null auto_increment comment '购物序列',
    user_id              int not null comment '会员ID',
    business_code        varchar(32) not null comment '业务线编码',
    goods_code           int not null comment '商品编码',
    goods_name           varchar(64) not null comment '商品名称',
    goods_img            varchar(128) not null comment '商品图片',
    buy_counts           int not null comment '购买数量',
    cart_date            int not null comment '加车日期',
    additional           varchar(64) comment '附加参数',
    sellType             tinyint not null comment '销售类型',
    activity_code        varchar(32) comment '活动编码',
    activity_price       decimal(10,2) not null comment '活动价格',
    cart_status          tinyint not null comment '加车状态',
    create_time          datetime not null comment '添加时间',
    update_time          datetime not null comment '修改时间',
    primary key (cart_seq)
);
alter table otc_user_cart comment '会员购物车表';

drop index Index_order_no on otc_order;
drop table if exists otc_order;
/*==============================================================*/
/* Table: otc_order                                             */
/*==============================================================*/
create table otc_order
(
    order_seq            bigint not null auto_increment comment '订单序列',
    order_no             varchar(32) not null comment '订单号',
    salesman             int not null comment '业务员',
    order_type           tinyint not null comment '订单类型：1，普通订单；2，批发订单',
    business_code        varchar(32) not null comment '业务线编码',
    order_money          decimal(10,2) not null comment '订单金额',
    discount_rate        decimal(3,2) not null comment '折扣比例',
    discount_money       decimal(10,2) not null comment '折后金额',
    prefer_money         decimal(6,2) not null comment '优惠金额',
    post_money           decimal(6,2) not null comment '运输费用',
    recieve_addr         int not null comment '收货地址',
    pay_money            decimal(10,2) not null comment '支付金额',
    pay_model            tinyint not null comment '支付方式：1，在线支付；2，货到付款',
    pay_time             datetime comment '支付时间',
    send_time            datetime comment '发货时间',
    finish_time          datetime comment '交易完成时间',
    order_status         tinyint not null comment '订单状态：0，已取消；10，未付款；20，已付款；40，已发货；50，交易成功；60，交易关闭',
    create_time          datetime not null comment '创建时间',
    update_time          datetime not null comment '修改时间',
    primary key (order_seq)
);
alter table otc_order comment '订单表';
/*==============================================================*/
/* Index: Index_order_no                                        */
/*==============================================================*/
create unique index Index_order_no on otc_order
(
 order_no
    );


drop table if exists otc_order_detail;
/*==============================================================*/
/* Table: otc_order_detail                                      */
/*==============================================================*/
create table otc_order_detail
(
    detail_seq           bigint not null auto_increment comment '明细序列',
    user_id              int not null comment '会员ID',
    order_no             varchar(32) not null comment '订单号',
    child_order_no       varchar(32) not null comment '子订单号',
    goods_name           varchar(64) not null comment '商品名称',
    goods_code           int not null comment '商品编码',
    goods_img            varchar(128) not null comment '商品图片',
    goods_price          decimal(10,2) not null comment '商品价格',
    batch_price          decimal(10,2) not null comment '批发价格',
    goods_count          int not null comment '商品数量',
    goods_money          decimal(10,2) not null comment '商品总金额',
    discount_rate        decimal(3,2) not null comment '折扣比例',
    discount_moeny       decimal(10,2) not null comment '折后金额',
    create_time          datetime not null comment '创建时间',
    update_time          datetime not null comment '修改时间',
    primary key (detail_seq)
);
alter table otc_order_detail comment '订单明细表';


drop table if exists otc_order_payment;
/*==============================================================*/
/* Table: otc_order_payment                                     */
/*==============================================================*/
create table otc_order_payment
(
    pay_no               bigint not null auto_increment comment '支付号',
    trans_no             varchar(32) not null comment '交易流水号',
    order_no             varchar(32) not null comment '订单号',
    trans_money          decimal(10,2) not null comment '交易金额',
    pay_model            tinyint not null comment '支付方式：1，微信支付',
    supplier_no          varchar(32) not null comment '供应商编号',
    merchant_code        varchar(32) not null comment '商户号',
    bank_code            varchar(32) not null comment '银行编码',
    merchant_no          varchar(32) not null comment '供应商流水号',
    trans_detail         varchar(32) comment '交易明细',
    trans_status         tinyint not null comment '交易状态',
    pay_time             datetime comment '支付时间',
    lock_flg             tinyint not null comment '标志位：1，初始化；2，待执行；3，执行中；4，执行成功；5，执行失败',
    run_count            int not null comment '执行次数',
    lock_time            datetime not null comment '锁定记录的时间',
    create_time          datetime not null comment '添加时间',
    update_time          datetime not null comment '更新时间',
    primary key (pay_no)
);
alter table otc_order_payment comment '订单支付表';


drop table if exists otc_order_child;
/*==============================================================*/
/* Table: otc_order_child                                       */
/*==============================================================*/
create table otc_order_child
(
    child_seq            bigint not null auto_increment comment '子单序列',
    child_order_no       varchar(32) not null comment '子订单号',
    order_no             varchar(32) not null comment '订单号',
    delivery_model       tinyint not null comment '配送方式：1，自己送货；2，三方送货',
    in_province          int not null comment '送达省份',
    in_city              int not null comment '送达城市',
    out_province         int not null comment '出货省份',
    out_city             int not null comment '出货城市',
    out_person           int comment '出货人',
    out_time             datetime comment '出货时间',
    transfer_person      int comment '转移人',
    transfer_reason      varchar(32) comment '转移原因',
    transfer_time        datetime comment '转移时间',
    create_time          datetime not null comment '创建时间',
    primary key (child_seq)
);
alter table otc_order_child comment '订单拆单子表';


drop table if exists otc_order_contract;
/*==============================================================*/
/* Table: otc_order_contract                                    */
/*==============================================================*/
create table otc_order_contract
(
    contract_seq         bigint not null auto_increment comment '履约序列',
    contract_no          varchar(32) not null comment '履约单号',
    order_no             varchar(32) not null comment '订单号',
    child_order_no       varchar(32) not null comment '子订单号',
    reciever             varchar(32) not null comment '收货人',
    telephone            varchar(32) not null comment '联系电话',
    recieve_addr         varchar(128) not null comment '收货地址',
    delivery_model       tinyint not null comment '配送方式',
    delivery_person      varchar(32) comment '配送人',
    delivery_mobile      varchar(32) comment '配送人号码',
    third_post           varchar(32) comment '三方物流',
    post_no              varchar(32) comment '物流运单号',
    update_time          datetime comment '修改时间',
    create_time          datetime not null comment '添加时间',
    primary key (contract_seq)
);
alter table otc_order_contract comment '订单履约表';


drop table if exists otc_post_detail;
/*==============================================================*/
/* Table: otc_post_detail                                       */
/*==============================================================*/
create table otc_post_detail
(
    post_seq             bigint not null auto_increment comment '运转序列',
    contract_no          varchar(32) not null comment '履约单号',
    order_no             varchar(32) not null comment '订单号',
    child_order_no       varchar(32) not null comment '子订单号',
    post_no              varchar(32) not null comment '物流运单号',
    post_type            tinyint not null comment '流转类型：1，已下单；2，仓库处理中；3，运输中；4，派送中；5，已签收',
    post_info            varchar(128) not null comment '流转信息',
    create_time          datetime not null comment '添加时间',
    primary key (post_seq)
);
alter table otc_post_detail comment '物流运转明细表';
