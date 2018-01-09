public class DirectoryTree {
    private class Node {
        String firstName;
        String lastName;
        int number;
        Node left;
        Node right;
        Node list;

        Node(String firstName, String lastName, int number, Node left, Node right,Node list)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.number = number;
            this.left = left;
            this.right = right;
            this.list = list;
        }

    }

    Node root;

    DirectoryTree()
    {
        root = new Node(null, null, 0, null,null,null);
    }

    public boolean isEmpty(Node root) // Checks if the tree is empty
    {
        if (root.firstName == null)
        {
            return true;
        }
        return false;
    }

    public void Display(Node root)
    {
        if(root == null)
        {
            return;
        }
        Display(root.left);
        Display(root.right);
        if(root.list==null)
        {
            System.out.println(root.firstName);
            System.out.println(root.lastName);
            System.out.println(root.number);
        }
        else
        {
            Node tracker = root;
            while(tracker!=null)
            {
                if(tracker.list==null)
                {
                    System.out.println(tracker.firstName);
                    System.out.println(tracker.lastName);
                    System.out.println(tracker.number);
                    return;
                }
                else
                {
                    System.out.println(tracker.firstName);
                    System.out.println(tracker.lastName);
                    System.out.println(tracker.number);
                    tracker = tracker.list;
                }
            }
        }


    }


    public void put(String firstName,String lastName, int number) // Adds a node or modifies the root if empty
    {
        if (isEmpty(root)) // If the root is empty we add values to the root
        {
            root.firstName = firstName;
            root.lastName = lastName;
            root.number = number;
        }
        else // Root isn't empty so we find where to put the name
        {
            Node temp = root;
            while (true) {
                int test = firstName.compareTo(temp.firstName);
                if (test > 0)   // Go right
                {
                    if (temp.right == null) // Add a new Node to the right
                    {
                        temp.right = new Node(firstName,lastName, number, null, null,null);
                        Display(root);
                        return;
                    } else //Moves temp down the right of the tree
                    {
                        temp = temp.right;
                    }
                }
                else if (test < 0) // Go left
                {
                    if (temp.left == null) // Add a new Node to the left
                    {
                        temp.left = new Node(firstName,lastName, number, null, null,null);
                        Display(root);
                        return;
                    }
                    else // Moves temp down to the left of the tree
                    {
                        temp = temp.left;
                    }
                }
                else // Same name means add number
                {
                    temp.list = new Node(firstName,lastName,number,null,null,null);
                    return;
                }
            }

        }
    }


    public void find(String firstName,String lastName) // Finds the person corresponding to the name
    {
        Node temp = root;
        if(isEmpty(temp)) // If empty tree just end
        {
            return;
        }
        while(true)
        {
            int test = firstName.compareTo(temp.firstName);
            int test2 = lastName.compareTo(temp.lastName);
            if(test==0)
            {
                if(temp.list == null || temp.lastName == lastName)
                {
                    System.out.println(temp.firstName);
                    System.out.println(temp.lastName);
                    System.out.println(temp.number);
                    return;
                }
                else
                {
                    Node tracker = temp;
                    //System.out.println(tracker.firstName);
                    //System.out.println(tracker.lastName);
                    //System.out.println(tracker.number);
                    while(tracker!=null)
                    {
                        if(tracker.list==null)
                        {
                            System.out.println(tracker.firstName);
                            System.out.println(tracker.lastName);
                            System.out.println(tracker.number);
                            return;
                        }
                        else
                        {
                            System.out.println(tracker.firstName);
                            System.out.println(tracker.lastName);
                            System.out.println(tracker.number);
                            tracker = tracker.list;
                        }
                    }
                }
            }
            else if(test<0) // Go left
            {
                temp = temp.left;
            }
            else // Go right
            {
                temp = temp.right;
            }
        }
    }



}


// NEED ISEQUAL METHOD


class Test
{
    public static void main(String[] args)
    {
        DirectoryTree Test = new DirectoryTree();
        Test.put("Mike","S",20);
        Test.put("Mike","B",2);
        Test.put("Mike","H",29);
        Test.put("Kid","Rock",17);
        //Test.find("Mike","H");

    }
}
