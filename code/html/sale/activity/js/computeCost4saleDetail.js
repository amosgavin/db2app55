//预计收入(修改后收入等于=用户数*月保底金额*保底月数)
function compute_pre_income(pre_person, total_bd){
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    //var PRE_INCOME2 = PRE_PERSON * TOTAL_BD;
    return accMul(pre_person,total_bd);
}

//预存送话费
function compute4weapon11(){
	//预计用户规模
	var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
    	PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //赠送话费金额
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //吸纳预存款（原预计收入）
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    //预计话费折扣
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
    	//BACK_PROPORTION = FEE_DISCOUNT / PRE_INCOME;
    	BACK_PROPORTION = accMul(accDiv(FEE_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != FEE_DISCOUNT){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / FEE_DISCOUNT;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,FEE_DISCOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(FEE_DISCOUNT);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),FEE_DISCOUNT);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存送电子券
function compute4weapon12(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //赠送电子券金额
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //预计收入
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);    
    
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //电子购物券成本
	    _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //手机支付红包成本
	    _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //电子提货券成本
	    _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    
    //客户回报率
    var BACK_PROPORTION = "";
    
    if(0 != PRESTORE_FEE){
        //BACK_PROPORTION = PRESENT_BUSI2_AMOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(PRESENT_BUSI2_AMOUNT,PRESTORE_FEE),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != PRESENT_BUSI2_AMOUNT){
        //PRE_STORE_TO_PRESENT = PRESTORE_FEE / PRESENT_BUSI2_AMOUNT;
    	
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRESTORE_FEE,PRESENT_BUSI2_AMOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(COST);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),COST);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存送和包红包
function compute4weapon18(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //赠送和包红包
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //预计收入
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);    
    
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //电子购物券成本
	    _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //手机支付红包成本
	    _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //电子提货券成本
	    _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    
    //客户回报率
    var BACK_PROPORTION = "";
    
    if(0 != PRESTORE_FEE){
        //BACK_PROPORTION = PRESENT_BUSI2_AMOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(PRESENT_BUSI2_AMOUNT,PRESTORE_FEE),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != PRESENT_BUSI2_AMOUNT){
        //PRE_STORE_TO_PRESENT = PRESTORE_FEE / PRESENT_BUSI2_AMOUNT;
    	
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRESTORE_FEE,PRESENT_BUSI2_AMOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(COST);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),COST);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存送货品
function compute4weapon13(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //货品业务总价值
    var  PRESENT_BUSI3_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI3_AMOUNT")){
        PRESENT_BUSI3_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI3_AMOUNT");
    }
    //货品销售指导价
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    
    //预计收入
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计货品成本
    var GOODS_COST = accMul(REFERENCE_PRICE, PRE_PERSON);
   _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = GOODS_COST / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(GOODS_COST,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != GOODS_COST){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / GOODS_COST;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,GOODS_COST),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(GOODS_COST);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),GOODS_COST);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存送自有业务
function compute4weapon14(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //赠送自有业务总价值
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //预计收入
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计业务折扣
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = BUSINESS_DISCOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(BUSINESS_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != BUSINESS_DISCOUNT){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / BUSINESS_DISCOUNT;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,BUSINESS_DISCOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(BUSINESS_DISCOUNT);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),BUSINESS_DISCOUNT);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存组合赠送
function compute4weapon15(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //赠送话费金额
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //赠送电子券金额
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE");
    }
  //赠送和包红包
    var  PRESENT_BUSI2_AMOUNT_HB = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB");
    }
    //货品销售指导价
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //赠送自有业务总价值
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,accAdd(PRESENT_BUSI2_AMOUNT,PRESENT_BUSI2_AMOUNT_HB)),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //预计收入
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    
    
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计话费折扣
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //电子券成本
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子购物券成本
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //手机支付红包成本
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子提货券成本
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //预计货品成本
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //预计业务折扣
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //总成本/折扣
    //var allCost = new Number(FEE_DISCOUNT) + new Number(COST) + new Number(GOODS_COST) + new Number(BUSINESS_DISCOUNT);
    var allCost = accAdd(accAdd(accAdd(FEE_DISCOUNT,COST),GOODS_COST),BUSINESS_DISCOUNT);
    
    
    
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //预存/赠送比例
    var PRE_STORE_TO_PRESENT = "";
    if(0 != allCost){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / allCost;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,allCost),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(allCost);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),allCost);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//预存送终端
function compute4weapon21(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //预存话费金额
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //终端实际购买款
    var  TERM_REAL_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("TERM_REAL_FEE")){
        TERM_REAL_FEE = _include_formWeaponSelectFormRowSet().getValue("TERM_REAL_FEE");
    }
    
    //预计收入
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计终端成本
    //var MOBILE_COST = TERM_REAL_FEE * PRE_PERSON;
    var MOBILE_COST = accMul(TERM_REAL_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("MOBILE_COST",MOBILE_COST);
    
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = MOBILE_COST / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(MOBILE_COST,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(MOBILE_COST);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),MOBILE_COST);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//购终端送话费
function compute4weapon22(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //赠送话费金额
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    
    //预计收入
    //var PRE_INCOME = PRE_PERSON * L_LIMIT * BASE_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,L_LIMIT),BASE_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计话费折扣
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = FEE_DISCOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(FEE_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(FEE_DISCOUNT);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),FEE_DISCOUNT);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//数据业务营销
function compute4weapon31(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //每月价值
    var VALUE_PERMONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH")){
        VALUE_PERMONTH = _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH");
    }
    //开通月数
    var OPEN_MONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("OPEN_MONTH")){
        OPEN_MONTH = _fromSaleDetailFormRowSet().getValue("OPEN_MONTH");
    }
    //赠送话费金额
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //赠送电子券金额
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT");
    }
    //货品销售指导价
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //赠送自有业务总价值
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,PRESENT_BUSI2_AMOUNT),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //预计收入
    //var PRE_INCOME = PRE_PERSON * VALUE_PERMONTH * OPEN_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,VALUE_PERMONTH),OPEN_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计话费折扣
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //电子券成本
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子购物券成本
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //手机支付红包成本
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子提货券成本
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //预计货品成本
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //预计业务折扣
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //总成本/折扣
    //var allCost = new Number(FEE_DISCOUNT) + new Number(COST) + new Number(GOODS_COST) + new Number(BUSINESS_DISCOUNT);
    var allCost = accAdd(accAdd(accAdd(FEE_DISCOUNT,COST),GOODS_COST),BUSINESS_DISCOUNT);
    
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(allCost);
    var COST_TOTAL = accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),allCost);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}

//其它类型赠送活动
function compute4weapon41(){
    //预计用户规模
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //每月价值
    var VALUE_PERMONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH")){
        VALUE_PERMONTH = _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH");
    }
    //开通月数
    var OPEN_MONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("OPEN_MONTH")){
        OPEN_MONTH = _fromSaleDetailFormRowSet().getValue("OPEN_MONTH");
    }
    
    //赠送话费金额
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //赠送电子券金额
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT");
    }
    //货品销售指导价
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //赠送自有业务总价值
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,PRESENT_BUSI2_AMOUNT),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //预计收入
    //var PRE_INCOME = PRE_PERSON * VALUE_PERMONTH * OPEN_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,VALUE_PERMONTH),OPEN_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //预计收入(修改后收入等于=用户数*月保底金额*保底月数)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //预计话费折扣
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //电子券成本
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子购物券成本
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //手机支付红包成本
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //电子提货券成本
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //预计货品成本
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //预计业务折扣
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    
    
    //每月保底
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    
    //保底月数
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    
    //保底总金额
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //客户回报率
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //渠道酬金
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //广告宣传费
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //其他
    var ESTIMATE_OTHER_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE")){
        ESTIMATE_OTHER_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_OTHER_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_OTHER_FEE",0);
    }
    //var COST_TOTAL = new Number(CHANNEL_PAY) + new Number(ESTIMATE_AD_FEE) + new Number(ESTIMATE_OTHER_FEE) + new Number(GOODS_COST) + new Number(BUSINESS_DISCOUNT);
    var COST_TOTAL = accAdd(accAdd(accAdd(accAdd(CHANNEL_PAY,ESTIMATE_AD_FEE),ESTIMATE_OTHER_FEE),GOODS_COST),BUSINESS_DISCOUNT);
    _fromSaleDetailFormRowSet().setValue("COST_TOTAL",COST_TOTAL);
}