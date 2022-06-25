package Bean;

import java.util.Date;

public class OutMoney {
    private Integer id;/*退款id*/
    private Double outPrice;/*支付金额*/
    private Date createDate;/*创建时间*/
    private Integer outId;/*退房id*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(Double outPrice) {
        this.outPrice = outPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    @Override
    public String toString() {
        return "OutMoney{" +
                "id=" + id +
                ", outPrice=" + outPrice +
                ", createDate=" + createDate +
                ", outId=" + outId +
                '}';
    }
}
