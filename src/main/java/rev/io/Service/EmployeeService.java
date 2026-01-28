package rev.io.Service;
import java.sql.Date;

import rev.co.model.LeaveApplication;
import rev.co.Repo.*;
//import rev.co.repository.LeaveRepository;
//import rev.co.repository.NotificationRepository;
import rev.co.util.InputUtil;
import rev.co.util.SessionManager;
public class EmployeeService {
	LeaveRepository leaveRepo = new LeaveRepository();
    NotificationRepository notiRepo = new NotificationRepository();

    public void applyLeave() {

        LeaveApplication leave = new LeaveApplication();
        leave.setEmpId(SessionManager.getEmpId());

        System.out.print("Leave Type: ");
        leave.setLeaveType(InputUtil.sc.next());

        System.out.print("From Date (yyyy-mm-dd): ");
        leave.setFromDate(Date.valueOf(InputUtil.sc.next()));

        System.out.print("To Date (yyyy-mm-dd): ");
        leave.setToDate(Date.valueOf(InputUtil.sc.next()));

        System.out.print("Reason: ");
        leave.setReason(InputUtil.sc.next());

        leaveRepo.insertLeave(leave);
        notiRepo.saveNotification(
            SessionManager.getEmpId(),
            "Leave applied successfully"
        );

        System.out.println("Leave Applied");
    }
}
