//Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
function compute_pre_income(pre_person, total_bd){
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    //var PRE_INCOME2 = PRE_PERSON * TOTAL_BD;
    return accMul(pre_person,total_bd);
}

//Ԥ���ͻ���
function compute4weapon11(){
	//Ԥ���û���ģ
	var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
    	PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //���ͻ��ѽ��
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //����Ԥ��ԭԤ�����룩
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    //Ԥ�ƻ����ۿ�
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
    	//BACK_PROPORTION = FEE_DISCOUNT / PRE_INCOME;
    	BACK_PROPORTION = accMul(accDiv(FEE_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != FEE_DISCOUNT){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / FEE_DISCOUNT;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,FEE_DISCOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ���͵���ȯ
function compute4weapon12(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //���͵���ȯ���
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //Ԥ������
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);    
    
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //���ӹ���ȯ�ɱ�
	    _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //�ֻ�֧������ɱ�
	    _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //�������ȯ�ɱ�
	    _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    
    if(0 != PRESTORE_FEE){
        //BACK_PROPORTION = PRESENT_BUSI2_AMOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(PRESENT_BUSI2_AMOUNT,PRESTORE_FEE),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != PRESENT_BUSI2_AMOUNT){
        //PRE_STORE_TO_PRESENT = PRESTORE_FEE / PRESENT_BUSI2_AMOUNT;
    	
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRESTORE_FEE,PRESENT_BUSI2_AMOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ���ͺͰ����
function compute4weapon18(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //���ͺͰ����
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //Ԥ������
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);    
    
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //���ӹ���ȯ�ɱ�
	    _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //�ֻ�֧������ɱ�
	    _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
	    //�������ȯ�ɱ�
	    _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    
    if(0 != PRESTORE_FEE){
        //BACK_PROPORTION = PRESENT_BUSI2_AMOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(PRESENT_BUSI2_AMOUNT,PRESTORE_FEE),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != PRESENT_BUSI2_AMOUNT){
        //PRE_STORE_TO_PRESENT = PRESTORE_FEE / PRESENT_BUSI2_AMOUNT;
    	
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRESTORE_FEE,PRESENT_BUSI2_AMOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ���ͻ�Ʒ
function compute4weapon13(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //��Ʒҵ���ܼ�ֵ
    var  PRESENT_BUSI3_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI3_AMOUNT")){
        PRESENT_BUSI3_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI3_AMOUNT");
    }
    //��Ʒ����ָ����
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    
    //Ԥ������
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ�ƻ�Ʒ�ɱ�
    var GOODS_COST = accMul(REFERENCE_PRICE, PRE_PERSON);
   _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = GOODS_COST / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(GOODS_COST,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != GOODS_COST){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / GOODS_COST;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,GOODS_COST),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ��������ҵ��
function compute4weapon14(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //��������ҵ���ܼ�ֵ
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //Ԥ������
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ��ҵ���ۿ�
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = BUSINESS_DISCOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(BUSINESS_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != BUSINESS_DISCOUNT){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / BUSINESS_DISCOUNT;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,BUSINESS_DISCOUNT),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ���������
function compute4weapon15(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //���ͻ��ѽ��
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //���͵���ȯ���
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE");
    }
  //���ͺͰ����
    var  PRESENT_BUSI2_AMOUNT_HB = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("ADD_MONTHCHARGE_HB");
    }
    //��Ʒ����ָ����
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //��������ҵ���ܼ�ֵ
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,accAdd(PRESENT_BUSI2_AMOUNT,PRESENT_BUSI2_AMOUNT_HB)),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //Ԥ������
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    
    
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ�ƻ����ۿ�
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //����ȯ�ɱ�
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //���ӹ���ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�ֻ�֧������ɱ�
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�������ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //Ԥ�ƻ�Ʒ�ɱ�
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //Ԥ��ҵ���ۿ�
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //�ܳɱ�/�ۿ�
    //var allCost = new Number(FEE_DISCOUNT) + new Number(COST) + new Number(GOODS_COST) + new Number(BUSINESS_DISCOUNT);
    var allCost = accAdd(accAdd(accAdd(FEE_DISCOUNT,COST),GOODS_COST),BUSINESS_DISCOUNT);
    
    
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    //Ԥ��/���ͱ���
    var PRE_STORE_TO_PRESENT = "";
    if(0 != allCost){
        //PRE_STORE_TO_PRESENT = PRE_INCOME / allCost;
        PRE_STORE_TO_PRESENT = accMul(accDiv(PRE_INCOME,allCost),100);
    }
    _fromSaleDetailFormRowSet().setValue("PRE_STORE_TO_PRESENT",PRE_STORE_TO_PRESENT);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//Ԥ�����ն�
function compute4weapon21(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //Ԥ�滰�ѽ��
    var PRESTORE_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE")){
        PRESTORE_FEE = _include_formWeaponSelectFormRowSet().getValue("PRESTORE_FEE");
    }
    //�ն�ʵ�ʹ����
    var  TERM_REAL_FEE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("TERM_REAL_FEE")){
        TERM_REAL_FEE = _include_formWeaponSelectFormRowSet().getValue("TERM_REAL_FEE");
    }
    
    //Ԥ������
    //var PRE_INCOME = PRESTORE_FEE * PRE_PERSON;
    var PRE_INCOME = accMul(PRESTORE_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
    
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ���ն˳ɱ�
    //var MOBILE_COST = TERM_REAL_FEE * PRE_PERSON;
    var MOBILE_COST = accMul(TERM_REAL_FEE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("MOBILE_COST",MOBILE_COST);
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = MOBILE_COST / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(MOBILE_COST,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//���ն��ͻ���
function compute4weapon22(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //���ͻ��ѽ��
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    
    //Ԥ������
    //var PRE_INCOME = PRE_PERSON * L_LIMIT * BASE_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,L_LIMIT),BASE_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ�ƻ����ۿ�
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != PRE_INCOME){
        //BACK_PROPORTION = FEE_DISCOUNT / PRE_INCOME;
        BACK_PROPORTION = accMul(accDiv(FEE_DISCOUNT,PRE_INCOME),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//����ҵ��Ӫ��
function compute4weapon31(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //ÿ�¼�ֵ
    var VALUE_PERMONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH")){
        VALUE_PERMONTH = _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH");
    }
    //��ͨ����
    var OPEN_MONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("OPEN_MONTH")){
        OPEN_MONTH = _fromSaleDetailFormRowSet().getValue("OPEN_MONTH");
    }
    //���ͻ��ѽ��
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //���͵���ȯ���
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT");
    }
    //��Ʒ����ָ����
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //��������ҵ���ܼ�ֵ
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,PRESENT_BUSI2_AMOUNT),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //Ԥ������
    //var PRE_INCOME = PRE_PERSON * VALUE_PERMONTH * OPEN_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,VALUE_PERMONTH),OPEN_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ�ƻ����ۿ�
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //����ȯ�ɱ�
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //���ӹ���ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�ֻ�֧������ɱ�
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�������ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //Ԥ�ƻ�Ʒ�ɱ�
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //Ԥ��ҵ���ۿ�
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    //�ܳɱ�/�ۿ�
    //var allCost = new Number(FEE_DISCOUNT) + new Number(COST) + new Number(GOODS_COST) + new Number(BUSINESS_DISCOUNT);
    var allCost = accAdd(accAdd(accAdd(FEE_DISCOUNT,COST),GOODS_COST),BUSINESS_DISCOUNT);
    
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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

//�����������ͻ
function compute4weapon41(){
    //Ԥ���û���ģ
    var PRE_PERSON = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("PRE_PERSON")){
        PRE_PERSON = _fromSaleDetailFormRowSet().getValue("PRE_PERSON");
    }
    //ÿ�¼�ֵ
    var VALUE_PERMONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH")){
        VALUE_PERMONTH = _fromSaleDetailFormRowSet().getValue("VALUE_PERMONTH");
    }
    //��ͨ����
    var OPEN_MONTH = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("OPEN_MONTH")){
        OPEN_MONTH = _fromSaleDetailFormRowSet().getValue("OPEN_MONTH");
    }
    
    //���ͻ��ѽ��
    var  PRESENT_BUSI_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT")){
        PRESENT_BUSI_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI_AMOUNT");
    }
    //���͵���ȯ���
    var  PRESENT_BUSI2_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT")){
        PRESENT_BUSI2_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI2_AMOUNT");
    }
    //��Ʒ����ָ����
    var  REFERENCE_PRICE = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE")){
        REFERENCE_PRICE = _include_formWeaponSelectFormRowSet().getValue("REFERENCE_PRICE");
    }
    //��������ҵ���ܼ�ֵ
    var  PRESENT_BUSI4_AMOUNT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT")){
        PRESENT_BUSI4_AMOUNT = _include_formWeaponSelectFormRowSet().getValue("PRESENT_BUSI4_AMOUNT");
    }
    var allCostS = accAdd(accAdd(accAdd(PRESENT_BUSI_AMOUNT,PRESENT_BUSI2_AMOUNT),REFERENCE_PRICE),PRESENT_BUSI4_AMOUNT);
    
    //Ԥ������
    //var PRE_INCOME = PRE_PERSON * VALUE_PERMONTH * OPEN_MONTH;
    var PRE_INCOME = accMul(accMul(PRE_PERSON,VALUE_PERMONTH),OPEN_MONTH);
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME",PRE_INCOME);
        
    //Ԥ������(�޸ĺ��������=�û���*�±��׽��*��������)
    _fromSaleDetailFormRowSet().setValue("PRE_INCOME2",compute_pre_income(PRE_PERSON,TOTAL_BD));
    
    //Ԥ�ƻ����ۿ�
    //var FEE_DISCOUNT = PRESENT_BUSI_AMOUNT * PRE_PERSON;
    var FEE_DISCOUNT = accMul(PRESENT_BUSI_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("FEE_DISCOUNT",FEE_DISCOUNT);
    //����ȯ�ɱ�
    //var COST = PRESENT_BUSI2_AMOUNT * PRE_PERSON;
    var COST = accMul(PRESENT_BUSI2_AMOUNT,PRE_PERSON);
    if("1" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //���ӹ���ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECPAY_COST",COST);
    } else if("2" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�ֻ�֧������ɱ�
        _fromSaleDetailFormRowSet().setValue("MOBILEPAY_COST",COST);
    } else if("3" == _include_formWeaponSelectFormRowSet().getValue("ZFQ_TYPE")){
        //�������ȯ�ɱ�
        _fromSaleDetailFormRowSet().setValue("ELECGOODS_COST",COST);
    }
    //Ԥ�ƻ�Ʒ�ɱ�
    //var GOODS_COST = REFERENCE_PRICE * PRE_PERSON;
    var GOODS_COST = accMul(REFERENCE_PRICE,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("GOODS_COST",GOODS_COST);
    //Ԥ��ҵ���ۿ�
    //var BUSINESS_DISCOUNT = PRESENT_BUSI4_AMOUNT * PRE_PERSON;
    var BUSINESS_DISCOUNT = accMul(PRESENT_BUSI4_AMOUNT,PRE_PERSON);
    _fromSaleDetailFormRowSet().setValue("BUSINESS_DISCOUNT",BUSINESS_DISCOUNT);
    
    
    //ÿ�±���
    var L_LIMIT = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("L_LIMIT")){
        L_LIMIT = _include_formWeaponSelectFormRowSet().getValue("L_LIMIT");
    }
    
    //��������
    var BASE_MONTH = 0;
    if("" != _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH")){
        BASE_MONTH = _include_formWeaponSelectFormRowSet().getValue("BASE_MONTH");
    }
    
    //�����ܽ��
    var TOTAL_BD = accMul(L_LIMIT,BASE_MONTH);
    
    //�ͻ��ر���
    var BACK_PROPORTION = "";
    if(0 != TOTAL_BD){
        //BACK_PROPORTION = allCostS / TOTAL_BD;
        BACK_PROPORTION = accMul(accDiv(allCostS,TOTAL_BD),100);
    }
    _fromSaleDetailFormRowSet().setValue("BACK_PROPORTION",BACK_PROPORTION);
    
    //�������
    var CHANNEL_PAY = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY")){
        CHANNEL_PAY = _fromSaleDetailFormRowSet().getValue("CHANNEL_PAY");
    } else {
    	_fromSaleDetailFormRowSet().setValue("CHANNEL_PAY",0);
    }
    //���������
    var ESTIMATE_AD_FEE = 0;
    if("" != _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE")){
        ESTIMATE_AD_FEE = _fromSaleDetailFormRowSet().getValue("ESTIMATE_AD_FEE");
    } else {
    	_fromSaleDetailFormRowSet().setValue("ESTIMATE_AD_FEE",0);
    }
    //����
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