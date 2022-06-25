package Bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Checkin {
    private Integer id;
    private Integer roomtypeid;
    private Integer roomid;
    private String customername;
    private String idcard;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivedate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leavedate;
    private BigDecimal payprice;
    /*1.已入住,2.已离店*/
    private Integer status;
    private String remark;
    private Integer ordersid;
    private Integer createdby;
    private Date createdate;
    private Integer modifyby;
    private Date modifydate;
    private Double myprice;
    private BigDecimal outprice;

    public BigDecimal getOutprice() {
        return outprice;
    }

    public void setOutprice(BigDecimal outprice) {
        this.outprice = outprice;
    }

    public Double getMyprice() {
        return myprice;
    }

    public void setMyprice(Double myprice) {
        this.myprice = myprice;
    }

    //房型对象
    private RoomType roomType;
    //房间对象
    private Room room;
    /*退款对象*/
    private OutMoney outMoney;


    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public OutMoney getOutMoney() {
        return outMoney;
    }

    public void setOutMoney(OutMoney outMoney) {
        this.outMoney = outMoney;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getArrivedate() {
        return arrivedate;
    }

    public void setArrivedate(Date arrivedate) {
        this.arrivedate = arrivedate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public BigDecimal getPayprice() {
        return payprice;
    }

    public void setPayprice(BigDecimal payprice) {
        this.payprice = payprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public Integer getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Integer createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getModifyby() {
        return modifyby;
    }

    public void setModifyby(Integer modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    @Override
    public String toString() {
        return "Checkin{" +
                "id=" + id +
                ", roomtypeid=" + roomtypeid +
                ", roomid=" + roomid +
                ", customername='" + customername + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", arrivedate=" + arrivedate +
                ", leavedate=" + leavedate +
                ", payprice=" + payprice +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", ordersid=" + ordersid +
                ", createdby=" + createdby +
                ", createdate=" + createdate +
                ", modifyby=" + modifyby +
                ", modifydate=" + modifydate +
                ", roomType=" + roomType +
                ", room=" + room +
                ", outMoney=" + outMoney +
                '}';
    }
}
