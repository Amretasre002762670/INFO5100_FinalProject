/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.WorkQueue;

import Model.Customer.Customer;
import Model.DeliveryMan.DeliveryMan;
import Model.Restaurant.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author puppalanagavaishnavi
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void addWorkRequest(WorkRequest workRequest) {
        workRequestList.add(workRequest);
    }

    public WorkRequest findWorkrequestForCustomer(Customer cusDetails) {
        WorkRequest searchResult = new WorkRequest();
        for (WorkRequest workReq : workRequestList) {
            if (workReq.getCusAcct().getUsername().equals(cusDetails.getCustName())) {
                searchResult = workReq;
                break;
            }
        }
        return searchResult;
    }

    public WorkRequest findCurrentWorkRequestForDelMan(DeliveryMan delDetails) {
        WorkRequest currentWork = new WorkRequest();
        for (WorkRequest work : workRequestList) {
            if (work.getOrderRequest().getDeliverManDetails().getDeliveryManName().equals(delDetails.getDeliveryManName())) {
                currentWork = work;
            }
        }
        return currentWork;
    }

    public void removeWorkRequest(WorkRequest wrkReq) {
        if (wrkReq.getMessage().equals("Delivered") && wrkReq.getStatus().equals("negative")) {
            workRequestList.remove(wrkReq);
        }
    }
    
    public ArrayList<WorkRequest> findResWorkQueue(Restaurant selectedRes) {
        
       ArrayList<WorkRequest> workReqList = new ArrayList<WorkRequest>();
       
       for(WorkRequest workReq: workRequestList) {
           if((workReq.getOrderRequest().getResDetails().getRestaurantId() == selectedRes.getRestaurantId()) 
                   && (workReq.getOrderRequest().getResDetails().getRestaurantName().equals(selectedRes.getRestaurantName()))) {
               workReqList.add(workReq);
           }
       }
       
       return workReqList;
    }
}
