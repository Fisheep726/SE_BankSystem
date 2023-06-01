package Entity;

import java.util.Date;

public class SaverAccount extends Account{
    Date noticeDate;
    double noticeAmount;
    public SaverAccount(int accNo,Customer customer){
        super(accNo,customer);
        this.overDraftLimit = 0.0;
    }

    public void setNoticeAmount(double noticeAmount){
        this.noticeAmount = noticeAmount;
    }

    public double getNoticeAmount(){
        return noticeAmount;
    }

    public void setNoticeDate(Date noticeDate){
        this.noticeDate = noticeDate;
    }

    public Date getNoticeDate(){
        return noticeDate;
    }
}
