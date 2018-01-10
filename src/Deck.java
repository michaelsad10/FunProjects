 class Deck
{
    private class Card
    {
        String suit;
        int rank;
        Card(String suit, int rank)
        {
            this.suit = suit;
            this.rank = rank;
        }
    }
    int Deck[];
    Deck(int size)
    {
        Deck = new int[size];
    }

    public void put(String suit, int rank)
    {
            
    }
}


class Test
{
    public static void main(String[] args)
    {
        int size = 52;
        int[] Deck;
        Deck Test = new Deck(size);
    }
}
