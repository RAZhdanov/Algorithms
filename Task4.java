//https://leetcode.com/problems/add-two-numbers/submissions/
public class Task {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode resultNode = new ListNode();
    ListNode header = resultNode;
    int ten = 0;
    while(l1 != null || l2 != null){

      int result = 0;

      if(l1 != null && l2 != null){
        result = (l1.val + l2.val) + ten;
        ten = 0;
        resultNode.val = result % 10;
        ten = result / 10;
        l1 = l1.next;
        l2 = l2.next;
      }
      else if(l1 != null){
        result = (l1.val + ten);
        ten = 0;
        resultNode.val = result % 10;
        ten = result / 10;
        l1 = l1.next;
      }
      else {
        result = (ten + l2.val);
        ten = 0;
        resultNode.val = result % 10;
        ten = result / 10;
        l2 = l2.next;
      }

      if((l1 != null || l2 != null)){
        resultNode.next = new ListNode();
        resultNode = resultNode.next;
      }
      else if(l1 == null && l2 == null && ten != 0){
        resultNode.next = new ListNode();
        resultNode = resultNode.next;
        resultNode.val = ten;
      }
    }

    return header;
  }

  public static void main(String[] args) {

    ListNode listNode1 = new ListNode(9);
    ListNode header1 = listNode1;

    listNode1 =  listNode1.next = new ListNode(9);

    listNode1 = listNode1.next = new ListNode(9);

    listNode1 =  listNode1.next = new ListNode(9);

    listNode1 = listNode1.next = new ListNode(9);
    listNode1 =  listNode1.next = new ListNode(9);

    listNode1 = listNode1.next = new ListNode(9);


    ListNode listNode2 = new ListNode(9);
    ListNode header2 = listNode2;

    listNode2 = listNode2.next = new ListNode(9);
    listNode2 = listNode2.next = new ListNode(9);
    listNode2 = listNode2.next = new ListNode(9);
    ListNode listNode = addTwoNumbers(header1, header2);
  }
}
