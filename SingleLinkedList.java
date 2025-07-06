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

  public ListNode insertAt(int data, int position) {
    if (position < 1) {
      throw new IllegalArgumentException("Position must be greater than or equal to 1");
    }

    if (head == null && position > 1) {
      throw new IllegalArgumentException("Cannot insert at position " + position + " in an empty list");
    }

    if (position == 1) {
      return insertFirst(data);
    }

    ListNode newNode = new ListNode(data);

    int index = 1;
    ListNode current = head;

    // Move index until it reaches position
    while (index < position - 1 && current != null) {
      current = current.next;
      index++;
    }

    if (current == null) {
      throw new IllegalArgumentException("Position " + position + " is out of bounds");
    }

    newNode.next = current.next;
    current.next = newNode;

    return newNode;
  }

  public ListNode deleteFirst() {
    if (head == null) {
      throw new IllegalStateException("List is empty, cannot delete first node");
    }

    ListNode first = head;
    head = first.next;
    first.next = null;
    return first;
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

    System.out.println("Inserting 50 at position 3:");
    sll.insertAt(50, 3);
    sll.printData();

    System.out.println("Deleting the first node:");
    ListNode deletedNode = sll.deleteFirst();
    System.out.println("Deleted node with data: " + deletedNode.data);
    sll.printData();

  }
}
