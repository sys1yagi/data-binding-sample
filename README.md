# data-binding-sample

see more [Data Binding Guide](https://developer.android.com/tools/data-binding/guide.html).

## Samples

- [SimpleBindingActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/SimpleBindingActivity.java)
  - Hello World!
- [ViewsWithIDsActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/ViewsWithIDsActivity.java)
  - [Views With IDs](https://developer.android.com/tools/data-binding/guide.html#views_with_ids) sample. ViewHolder don't need anymore.
- [AvoidingNullPointerExceptionActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/AvoidingNullPointerExceptionActivity.java)
  - Generated data binding code automatically checks for nulls and avoid null pointer exceptions.
- [IncludeDataBindingLayoutActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/IncludeDataBindingLayoutActivity.java)
  - Variables may be passed into an included layout's binding from the containing layout.
- [AutoUpdateBindingActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/AutoUpdateBindingActivity.java)
  - When the bound variable is updated, it will set the View automatically.
- [ExpressionLanguageActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/ExpressionLanguageActivity.java)
- [MVVMActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/MVVMActivity.java)
  - Implementation of MVVM Pattern using Data Binding.
- [BindingAdapterActivity.java](https://github.com/sys1yagi/data-binding-sample/blob/master/app/src/main/java/com/sys1yagi/databindingsample/activities/BindingAdapterActivity.java)
  - @BindingAdapter sample.

## multi dex

__multi-dex-keep.txt__

```
-keep public class * extends android.databinding.ViewDataBinding {
 *;
}
```

__build.gradle__

```
android {
  defaultConfig {
    multiDexEnabled = true
    multiDexKeepProguard file('multi-dex-keep.txt')
  }
```

## Proguard

```
-dontwarn android.databinding.**
```
