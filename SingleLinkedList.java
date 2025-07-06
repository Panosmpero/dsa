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

  public void printData() {
    ListNode current = head;
    while (current != null) {
      System.out.print(current.data + " -> ");
      current = current.next;
    }
    System.out.println("null");
  }

  public int length() {
    if (head == null) {
      return 0;
    }

    ListNode current = head;
    int count = 0;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  public ListNode insertFirst(int data) {
    ListNode newNode = new ListNode(data);
    newNode.next = head;
    head = newNode;
    return head;
  }

  public ListNode insertLast(int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
      return newNode;
    }

    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = newNode;
    return newNode;
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

    System.out.println("Traversing the Single Linked List:");
    sll.printData();

    System.out.println("Length of the Single Linked List: " + sll.length());

    System.out.println("Inserting 5 at the beginning:");
    sll.insertFirst(5);
    sll.printData();

    System.out.println("Adding 20 at the end:");
    sll.insertLast(20);
    sll.printData();

    System.out.println("Inserting 100 at the beginning to make sure head is correct:");
    sll.insertFirst(100);
    sll.printData();
  }
}
