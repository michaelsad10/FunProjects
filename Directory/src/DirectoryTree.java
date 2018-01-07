public class DirectoryTree {
    private class Node {
        String name;
        int number;
        Node left;
        Node right;
        Node list;

        Node(String name, int number, Node left, Node right,Node list)
        {
            this.name = name;
            this.number = number;
            this.left = left;
            this.right = right;
            this.list = list;
        }

    }

    Node root;

    DirectoryTree() {
        root = new Node(null, 0, null, null,null);
    }

    public boolean isEmpty(Node root) // Checks if the tree is empty
    {
        if (root.name == null) {
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
        System.out.println(root.name);
    }


    public void put(String name, int number) // Adds a node or modifies the root if empty
    {
        if (isEmpty(root)) // If the root is empty we add values to the root
        {
            root.name = name;
            root.number = number;
        } else // Root isn't empty so we find where to put the name
        {
            Node temp = root;
            while (true) {
                int test = name.compareTo(temp.name);
                if (test > 0)   // Go right
                {
                    if (temp.right == null) // Add a new Node to the right
                    {
                        temp.right = new Node(name, number, null, null,null);
                        //System.out.println(temp.right.name);
                        //Display(root);
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
                        temp.left = new Node(name, number, null, null,null);
                        //System.out.println(temp.left.name);
                        //Display(root);
                        return;
                    }
                    else // Moves temp down to the left of the tree
                    {
                        temp = temp.left;
                    }
                }
                else // Same name means add number
                {
                    temp.list = new Node(name,number,null,null,null);
                    return;
                }
            }

        }
    }


    public void find(String name) // Finds the person corresponding to the name
    {
        Node temp = root;
        if(isEmpty(temp)) // If empty tree just end
        {
            return;
        }
        while(true)
        {
            int test = name.compareTo(temp.name);
            if(test==0)
            {
                if(temp.list == null)
                {
                    System.out.println(temp.name);
                    System.out.println(temp.number);
                    return;
                }
                else
                {
                    System.out.println(temp.name);
                    System.out.println(temp.number);
                    Node tracker = temp;
                    while(tracker!=null)
                    {
                        if(tracker.list==null)
                        {
                            System.out.println(tracker.name);
                            System.out.println(tracker.number);
                            return;
                        }
                        else
                        {
                            System.out.println(tracker.name);
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
        Test.put("Mike",1);
        Test.put("Jag",2);
        Test.put("Z",2);
        Test.put("Mikey",3);
        Test.put("Fred",2);
        Test.put("fred",2);
        Test.put("mike",189);
        Test.put("mike",20);
        Test.find("mike");

    }
}
