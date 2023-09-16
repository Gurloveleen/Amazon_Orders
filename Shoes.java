public class Shoes extends Product
{
    private int size;
    private static enum Color={BLUE,BROWN}
    private Color color;

    int blue6;
    int blue7;
    int blue8;
    int blue9;
    int blue10;
    int brown6;
    int brown7;
    int brown8;
    int brown9;
    int brown10;
    public Shoes(String name, String id, double price, int b6, int b7, int b8, int b9, int b10, int br6, int br7, int br8, int br9, int br10)
    {
        super(name, id, price, b6 + b7 + b8 + b9 + b10 + br6 + br7 + br8 + br9 + br10 ,Category.CLOTHING);
        blue6 = b6;
        blue7 = b7;
        blue8 = b8;
        blue9  = b9;
        blue10 = b10;
        brown6 = br6;
        brown7 = br7;
        brown8 = br8;
        brown9 = br9;
        brown10 = br10;
    }


    public boolean validOptions(String productOptions)// checking if the format provided is valid or not
    {

        boolean result = false;
        if(productOptions.contains("6") | productOptions.contains("7") | productOptions.contains("8") | productOptions.contains("9") | productOptions.contains("10"))//checking if shoe size is between 6 and 10
            if(productOptions.contains("Brown") | productOptions.contains("Blue"))// checking if the colour is black or brown
                result = true;
        return result;
    }


    public int getStockCount(String productOptions)// checking stocks for brown
    {
        int c = 0;
        if(productOptions.contains("6")) {
            if (productOptions.contains("Brown"))
                c = brown6;
            else
                c = black6;
        }else if (productOptions.contains("7")){
            if (productOptions.contains("Brown"))
                c = brown7;
            else
                c = black7;
        }else if (productOptions.contains("8")){
            if (productOptions.contains("Brown"))
                c = brown8;
            else
                c = black8;
        }else if (productOptions.contains("9")){
            if (productOptions.contains("Brown"))
                c = brown9;
            else
                c = black9;
        }else if (productOptions.contains("10")){
            if (productOptions.contains("Brown"))
                c = brown10;
            else
                c = black10;
        }
        return c;
    }

    //setting the stock of each shoe
    public void setStockCount(int stockCount, String productOptions)// setting stocks
    {

        if(productOptions.contains("6"))
        {
            if (productOptions.contains("Brown"))
                brown6 = stockCount;
            else
                black6 = stockCount;
        }
        else if (productOptions.contains("7"))
        {
            if (productOptions.contains("Brown"))
                brown7 = stockCount;
            else
                black7 = stockCount;
        }
        else if (productOptions.contains("8"))
        {
            if (productOptions.contains("Brown"))
                brown8 = stockCount;
            else
                black8 = stockCount;
        }
        else if (productOptions.contains("9"))
        {
            if (productOptions.contains("Brown"))
                brown9 = stockCount;
            else
                black9 = stockCount;
        }
        else if (productOptions.contains("10"))
        {
            if (productOptions.contains("Brown"))
                brown10 = stockCount;
            else
                black10 = stockCount;
        }

    }



    public void reduceStockCount(String productOptions)//decreasing the stockcount of the shoes
    {
        if(productOptions.contains("6"))
        {
            if (productOptions.contains("Brown"))
                --brown6;
            else
                --black6;
        }
        else if (productOptions.contains("7"))
        {
            if (productOptions.contains("Brown"))
                --brown7;
            else
                --black7;
        }
        else if (productOptions.contains("8"))
        {
            if (productOptions.contains("Brown"))
                --brown8;
            else
                --black8;
        }
        else if (productOptions.contains("9"))
        {
            if (productOptions.contains("Brown"))
                --brown9;
            else
                --black9;
        }
        else if (productOptions.contains("10")){
            if (productOptions.contains("Brown"))
                --brown10;
            else
                --black10;
        }
    }


    public void print()
    {

        super.print();//printing details of shoes
    }

}
