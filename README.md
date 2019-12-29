# GridViewPack  

<p align="center">
  <img src="https://cdn.learn2crack.com/wp-content/uploads/2016/03/cover-grid-1024x483.png"
   /> 
</p>


Following is the constructor for a GridLayoutManager.  

```java
GridLayoutManager (Context context, int spanCount, int orientation, boolean reverseLayout)
```

Sample usage of GridLayoutManager:  
```java

/**
AutoFitGridLayoutManager that auto fits the cells by the column width defined.
**/

/*AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
  recyclerView.setLayoutManager(layoutManager);*/

/**
Simple GridLayoutManager that spans two columns
**/
GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
recyclerView.setLayoutManager(manager);
```

