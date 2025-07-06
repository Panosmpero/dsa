public class SingleLinkedList {
  private ListNode head;

  private static class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    SingleLinkedList sll = new SingleLinkedList();
    sll.head = new ListNode(10);
    ListNode second = new ListNode(1);
    ListNode third = new ListNode(8);
    ListNode fourth = new ListNode(11);

    // Connect lists
    sll.head.next = second;
    second.next = third;
    third.next = fourth;
    System.out.println("Single Linked List created with nodes:");
    System.out.println("Head: " + sll.head.data);
    System.out.println("Second: " + sll.head.next.data);
    System.out.println("Third: " + sll.head.next.next.data);
    System.out.println("Fourth: " + sll.head.next.next.next.data);
    System.out.println("Next of Fourth: " + sll.head.next.next.next.next);
  }
}
