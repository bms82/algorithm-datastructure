package bms.solid;


public class Complaint {

    Long complaintNo;
    String type;
    String title;
    String content;


    void issueComplaint() {
        // 민원 추가
    }

    void submitComplaint() {
        // 민원 제출
    }

    void sendEmailNotification() {
        // 진행 상황 이메일 전송. -> 이 클래스에서는 부적절함.
    }

}
