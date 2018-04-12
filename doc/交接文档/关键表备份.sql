--vm_wf
--create table hbsale.vm_wf_bak like hbsale.vm_wf;
delete from hbsale.vm_wf_bak;
insert into hbsale.vm_wf_bak select * from hbsale.vm_wf;
select * from hbsale.vm_wf_bak except select * from hbsale.vm_wf;
--h_vm_wf
--create table hbsale.h_vm_wf_bak like hbsale.h_vm_wf;
delete from hbsale.h_vm_wf_bak;
insert into hbsale.h_vm_wf_bak select * from hbsale.h_vm_wf;
select * from hbsale.h_vm_wf_bak except select * from hbsale.h_vm_wf;
--vm_task
--create table hbsale.vm_task_bak like hbsale.vm_task;
delete from hbsale.vm_task_bak;
insert into hbsale.vm_task_bak select * from hbsale.vm_task;
select * from hbsale.vm_task_bak except select * from hbsale.vm_task;
--h_vm_task
--create table hbsale.h_vm_task_bak like hbsale.h_vm_task;
delete from hbsale.h_vm_task_bak;
insert into hbsale.h_vm_task_bak select * from hbsale.h_vm_task;
select * from hbsale.h_vm_task_bak except select * from hbsale.h_vm_task;
--vm_task_ts
--create table hbsale.vm_task_ts_bak like hbsale.vm_task_ts;
delete from hbsale.vm_task_ts_bak;
insert into hbsale.vm_task_ts_bak select * from hbsale.vm_task_ts;
select * from hbsale.vm_task_ts_bak except select * from hbsale.vm_task_ts;
--h_vm_task_ts
--create table hbsale.h_vm_task_ts_bak like hbsale.h_vm_task_ts;
delete from hbsale.h_vm_task_ts_bak;
insert into hbsale.h_vm_task_ts_bak select * from hbsale.h_vm_task_ts;
select * from hbsale.h_vm_task_ts_bak except select * from hbsale.h_vm_task_ts;
--vm_schedule
--create table hbsale.vm_schedule_bak like hbsale.vm_schedule;
delete from hbsale.vm_schedule_bak;
insert into hbsale.vm_schedule_bak select * from hbsale.vm_schedule;
select * from hbsale.vm_schedule_bak except select * from hbsale.vm_schedule;
--charge_main_t
--create table hbsale.charge_main_bak like hbsale.charge_main_t;
delete from hbsale.charge_main_bak;
insert into hbsale.charge_main_bak select * from hbsale.charge_main_t;
select * from hbsale.charge_main_bak except select * from hbsale.charge_main_t;
--charge_apply_main_t
--create table hbsale.charge_apply_main_bak like hbsale.charge_apply_main_t;
delete from hbsale.charge_apply_main_bak;
insert into hbsale.charge_apply_main_bak select * from hbsale.charge_apply_main_t;
select * from hbsale.charge_apply_main_bak except select * from hbsale.charge_apply_main_t;
--charge_info_t
--create table hbsale.charge_info_bak like hbsale.charge_info_t;
delete from hbsale.charge_info_bak;
insert into hbsale.charge_info_bak select * from hbsale.charge_info_t;
select * from hbsale.charge_info_bak except select * from hbsale.charge_info_t;
--sale_order_t
--create table hbsale.sale_order_bak like hbsale.sale_order_t;
delete from hbsale.sale_order_bak;
insert into hbsale.sale_order_bak select * from hbsale.sale_order_t;
select * from hbsale.sale_order_bak except select * from hbsale.sale_order_t;
--sale_main_t
--create table hbsale.sale_main_bak like hbsale.sale_main_t;
delete from hbsale.sale_main_bak;
insert into hbsale.sale_main_bak select * from hbsale.sale_main_t;
select * from hbsale.sale_main_bak except select * from hbsale.sale_main_t;
--sale_detail_t
--create table hbsale.sale_detail_bak like hbsale.sale_detail_t;
delete from hbsale.sale_detail_bak;
insert into hbsale.sale_detail_bak select * from hbsale.sale_detail_t;
select * from hbsale.sale_detail_bak except select * from hbsale.sale_detail_t;
--busi_change_t
--create table hbsale.busi_change_bak like hbsale.busi_change_t;
delete from hbsale.busi_change_bak;
insert into hbsale.busi_change_bak select * from hbsale.busi_change_t;
select * from hbsale.busi_change_bak except select * from hbsale.busi_change_t;
--sale_weapon_t
--create table hbsale.sale_weapon_bak like hbsale.sale_weapon_t;
delete from hbsale.sale_weapon_bak;
insert into hbsale.sale_weapon_bak select * from hbsale.sale_weapon_t;
select * from hbsale.sale_weapon_bak except select * from hbsale.sale_weapon_t;
--weapon_tag_rela_t
--create table hbsale.weapon_tag_rela_bak like hbsale.weapon_tag_rela_t;
delete from hbsale.weapon_tag_rela_bak;
insert into hbsale.weapon_tag_rela_bak select * from hbsale.weapon_tag_rela_t;
select * from hbsale.weapon_tag_rela_bak except select * from hbsale.weapon_tag_rela_t;
--sale_tag_detail_t
--create table hbsale.sale_tag_detail_bak like hbsale.sale_tag_detail_t;
delete from hbsale.sale_tag_detail_bak;
insert into hbsale.sale_tag_detail_bak select * from hbsale.sale_tag_detail_t;
select * from hbsale.sale_tag_detail_bak except select * from hbsale.sale_tag_detail_t;
--sale_hptag_detail_t
--create table hbsale.sale_hptag_detail_bak like hbsale.sale_hptag_detail_t;
delete from hbsale.sale_hptag_detail_bak;
insert into hbsale.sale_hptag_detail_bak select * from hbsale.sale_hptag_detail_t;
select * from hbsale.sale_hptag_detail_bak except select * from hbsale.sale_hptag_detail_t;
--sechb.sec_staff
--create table sechb.sec_staff_bak like sechb.sec_staff;
delete from sechb.sec_staff_bak;
insert into sechb.sec_staff_bak select * from sechb.sec_staff;
select * from sechb.sec_staff_bak except select * from sechb.sec_staff;
--hbsale.attach_file_t
delete from hbsale.attach_file_bak;
insert into hbsale.attach_file_bak select * from hbsale.attach_file_t;

--update sechb.sec_staff set bill_id=15997463508;
--delete from sechb.sec_staff;
--insert into sechb.sec_staff select * from sechb.sec_staff_bak