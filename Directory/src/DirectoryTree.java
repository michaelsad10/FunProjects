class DirectoryTree {
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
            System.out.println("1 " + firstName + "," + lastName + "," + number);
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
                        System.out.println("2 " + firstName + "," + lastName + "," + number);
                        return;

                    }
                    else //Moves temp down the right of the tree
                    {
                        temp = temp.right;
                    }
                }
                else if (test < 0) // Go left
                {
                    if (temp.left == null) // Add a new Node to the left
                    {
                        temp.left = new Node(firstName,lastName, number, null, null,null);
                        System.out.println("3 " + firstName + "," + lastName + "," + number);
                        return;
                    }
                    else // Moves temp down to the left of the tree
                    {
                        temp = temp.left;
                    }
                }
                else // Same name means add number
                {
                    if(temp.list == null)
                    {
                        temp.list = new Node(firstName,lastName,number,null,null,null);
                        System.out.println("4 " + firstName + "," + lastName + "," + number);
                        return;
                    }
                    else
                    {
                        Node track = temp;
                        while(track!=null)
                        {
                            if(track.list == null)
                            {
                                track.list = new Node(firstName,lastName,number,null,null,null);
                                System.out.println("5 " + firstName + "," + lastName + "," + number);
                                return;
                            }
                            else
                            {
                                System.out.println("I went through here");
                                track = track.list;
                            }
                        }
                    }
                }
            }

        }
    }


    public void find(String firstName, String lastName) // Finds the person corresponding to the name
    {
        if(isEmpty(root))
        {
            System.out.println("The tree is empty");
        }
        else
        {
            Node temp = root;
            int test = firstName.compareTo(temp.firstName);

            if(test<0) // Go left
            {
                temp = temp.left;
            }
            else if(test>0) // Go right
            {
                temp = temp.right;
            }
            else // We found the first name
            {
               if(temp.lastName.equals(lastName))
               {
                   System.out.println("Found 1 " + "," + temp.firstName + "," + temp.lastName + "," + temp.number);
               }
               else
               {
                   Node track = temp;
                   while(track!=null)
                   {
                       if(track.lastName.equals(lastName))
                       {
                           System.out.println("Found 2 " + track.firstName + "," + track.lastName + "," + track.number);
                           return;
                       }
                       else
                       {
                           System.out.println("I went through here");
                           track = track.list;
                       }
                   }
               }

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
        Test.put("Kid", "Rock",30);
        Test.put("Mike", "D",129);
        Test.find("Mike", "D");

    }



}
