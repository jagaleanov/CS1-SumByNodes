package nodesum;

public class ListOperations {

    Node headA = null;
    Node headB = null;
    int groups = 3;

    public ListOperations(String a, String b) {
        headA = stringToList(headA, a);
        headB = stringToList(headB, b);
    }

    public Node stringToList(Node head, String number) {

        System.out.println();
        System.out.println("entrada ");
        System.out.println(number);

        int zeros = groups - ((number.length() % groups == 0) ? 5 : (number.length() % groups));

        System.out.println("añadiendo " + zeros + " ceros para crear grupos de " + groups);

        for (int i = 0; i < zeros; i++) {
            number = '0' + number;
        }

        System.out.println("con ceros " + number);

        for (int i = 0; i < number.length(); i = i + groups) {
            head = this.addTail(head, number.substring(i, i + groups));
        }

        return head;
    }

    public Node addTail(Node head, String data) {

        if (head != null) {
            Node q = head;
            while (q.getNext() != null) {
                q = q.getNext();
            }

            q.setNext(new Node(data));
            q.getNext().setPrev(q);
        } else {
            head = new Node(data);
        }

        this.print(head);

        return head;
    }

    public Node addHead(Node head, String data) {

        if (head != null) {
            Node temp = head;
            head = new Node(data);
            head.setNext(temp);
            head.getNext().setPrev(head);

        } else {
            head = new Node(data);
        }

        this.print(head);

        return head;
    }

    public Node findTail(Node head) {
        Node tail = head;

        if (head != null) {
            while (tail.getNext() != null) {
                tail = tail.getNext();
            }
        }

        return tail;
    }

    public String sum() {

        Node result = null;
        System.out.println();
        System.out.println("sumando");

        Node tailA = findTail(headA);
        Node tailB = findTail(headB);

        if (tailA != null || tailB != null) {
            Node a = tailA;
            Node b = tailB;
            int carry = 0;
            while (a != null || b != null || carry > 0) {
                int total = 0;

                if (a == null && b == null) {
                    total = carry;
                } else if (a == null) {
                    total = Integer.parseInt(b.getData()) + carry;
                } else if (b == null) {
                    total = Integer.parseInt(a.getData()) + carry;
                } else {
                    total = Integer.parseInt(a.getData()) + Integer.parseInt(b.getData()) + carry;
                }

                carry = 0;

                String totalStr = String.valueOf(total);

                String subStr = "";
                if (totalStr.length() > groups) {
                    //System.out.println("cortando");
                    subStr = totalStr.substring(totalStr.length() - groups, totalStr.length());
                    //System.out.println("corte=" + totalStr.substring(0, totalStr.length() - groups));
                    carry = Integer.parseInt(totalStr.substring(0, totalStr.length() - groups));
                } else {
                    //System.out.println("pasando");
                    subStr = totalStr;
                }
                
                
                
                
                

        int zeros = groups - ((subStr.length() % groups == 0) ? 5 : (subStr.length() % groups));

        System.out.println("añadiendo " + zeros + " ceros para crear grupos de " + groups);

        for (int i = 0; i < zeros; i++) {
            subStr = '0' + subStr;
        }

        System.out.println("con ceros " + subStr);
                
                
                
                

                result = this.addHead(result, subStr);

                if (a != null) {
                    a = a.getPrev();
                }

                if (b != null) {
                    b = b.getPrev();
                }
            }
            return listToString(result);
        } else {
            return listToString(new Node("000"));
        }
    }

    public void print(Node head) {
        Node q = head;
        while (q != null) {
            System.out.print(q.getData() + " ");
            q = q.getNext();
        }
        System.out.println();
    }

    public String listToString(Node head) {
        String string = "";
        Node q = head;
        while (q != null) {
            string += q.getData();
            q = q.getNext();
        }
        return string;
    }
}
