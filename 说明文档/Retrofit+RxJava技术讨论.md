# Retrofit+RxJava技术讨论

标签（空格分隔）： 技术分享

---

#Retrofit
>改进、更新的意思，类似于listview和recyclerview的适配器
默认有okhttp(通过调整AS结构看到)
Retrofit通俗的说就是一个HTTP请求的一个框架，通过一个Interface来定义api的实现，通过注释的方式进行一些请求的设置。
###GitHub地址
>https://github.com/square/retrofit
###官网简介
>http://square.github.io/retrofit/
###Retrofit2中网络访问常用注解接口
* @GET   GET网络请求方式
* @PSOT  PSOT网络请求方式
* @Headers   头信息参数
* @Path   路径参数。替换url地址中"{"和"}"所包括的部分
* @Query  查询参数，将在地址url中追加类似"page=1"的字符串，形成提交给服务器端的请求参数
* @QueryMap  查询参数集合，在url地址中追加类似"type=text&count=30&page=1"的字符串
* @FormUrlEncoded  对表单域中填写内容进行编码处理，避免乱码
* @Field  指定form表单域中每个空间的name及相应的数值
* @FieldMap   表单域集合
* @Multipart  Post提交分块请求，如果上传文件，必须指定Multipart
* @Part   POST提交分块请求
* @Body   POST提交分块请求
####五部曲
* 1、定义一个接口(封装URL地址和数据请求)
* 2、实例化Retrofit
* 3、通过Retrofit实例创建接口服务对象
* 4、接口服务对象调用接口中方法，获得call对象
* 5、Call对象执行请求(异步、同步请求)
###什么是RxJava
[RxJava官网][1]
>其实， RxJava 的本质可以压缩为异步这一个词。说到根上，它就是一个实现异步操作的库
####RxJava相关推荐
[给 Android 开发者的 RxJava 详解][2]
[深入浅出RxJava（一：基础篇）][3]
[深入浅出RxJava(二：操作符)][4]
[深入浅出RxJava三--响应式的好处][5]
[深入浅出RxJava四-在Android中使用响应式编程][6]

####RxJava常用的几个操作符
#####FlatMap
* FlatMap是一个用处多多的操作符，可以将要数据根据你想要的规则进行转化后再发射出去。其原理就是将这个Observable转化为多个以原Observable发射的数据作为源数据的Observable，然后再将这多个Observable发射的数据整合发射出来，需要注意的是最后的顺序可能会交错地发射出来，如果对顺序有严格的要求的话可以使用concatmap操作符。FlatMapIterable和FlatMap基本相同，不同之处为其转化的多个Observable是使用Iterable作为源数据的。


#####GroupBy
* GroupBy操作符将原始Observable发射的数据按照key来拆分成一些小的Observable，然后这些小的Observable分别发射其所包含的的数据，类似于sql里面的groupBy。
在使用中，我们需要提供一个生成key的规则，所有key相同的数据会包含在同一个小的Observable种。另外我们还可以提供一个函数来对这些数据进行转化，有点类似于集成了flatMap

#####Distinct
* Distinct操作符的用处就是用来去重，非常好理解。如下图所示，所有重复的数据都会被过滤掉。还有一个操作符distinctUntilChanged,是用来过滤掉连续的重复数据。
>Distinct过滤掉了所有重复的数字，而DistinctUtilChanged只过滤掉重复的数字

#####SubscribOn/ObserverOn
* 这两个操作符在前面的例子中我们已经使用过多次了，使用起来十分方便。在android开发中，相信大家一定都遇到过不能在主线程修改UI的问题，所以不得不使用Handler、AsyncTask等来更新UI界面。使用SubscribOn和ObserverOn操作符，各种线程的问题都将变得十分地简单。
SubscribOn用来指定Observable在哪个线程上运行，我们可以指定在IO线程上运行也可以让其新开一个线程运行，当然也可以在当前线程上运行。一般来讲会指定在各种后台线程而不是主线程上运行，就如同AsyncTask的doInBackground一样。
#####ZIP
* Retrofit对Observable的支持使得它可以很简单的将多个REST请求结合起来。比如我们有一个请求是获取照片的，还有一个请求是获取元数据的，我们就可以将这两个请求并发的发出，并且等待两个结果都返回之后再做处理
```
Observable.zip(
    service.getUserPhoto(id),
    service.getPhotoMetadata(id),
    (photo, metadata) -> createPhotoWithData(photo, metadata))
    .subscribe(photoWithData -> showPhoto(photoWithData));
```
>http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2016/0325/4080.html
#####RxJava操作符(好多啊)
[RxJava操作符详细列表][7]

##RxJava+Retrofit封装
###Http 请求结果预处理
![](http://ww1.sinaimg.cn/large/006jcGvzgy1fdb2ef562tj30s80a00t7)
```
 private static final int SUCCESS = 1;

    private int status;

    private String message;

    private T data;

    //判断是否成功
    public boolean success() {
        return status == SUCCESS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
```
>然后这样我们可以做以下的数据转换
```
 /**
     * 数据转换
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<RealBaseBean<T>, T> compatResult() {
        return new Observable.Transformer<RealBaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<RealBaseBean<T>> baseBeanObservable) {

                return baseBeanObservable.flatMap(new Func1<RealBaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final RealBaseBean<T> tBaseBean) {
                        if (tBaseBean.success()) {

                            return Observable.create(new Observable.OnSubscribe<T>() {
                                @Override
                                public void call(Subscriber<? super T> subscriber) {
                                    try {
                                        subscriber.onNext(tBaseBean.getData());
                                        subscriber.onCompleted();
                                    } catch (Exception e
                                            ) {
                                        subscriber.onError(e);
                                    }

                                }
                            });

                        } else {
                            return Observable.error(new ApiException(tBaseBean.getStatus(), tBaseBean.getMessage()));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }
```
####2. 统一错误处理
>详见代码里面的rx->exception里面的类解析(自定义处理请求异常)

[自定义GsonConverter处理请求错误异常][8]

###扩展知识
* [cache缓存][9]
* [添加统一请求参数][10]
* [okhttp的参数封装][11]
* [Okhttp的使用技巧与拦截器的使用分析][12]
* [RxJava总结好的几个知识点(***挺详细的哈,总结的RxJava的知识点比较全***)][13]
* [RxJava 与 Retrofit 结合的最佳实践][14]

###写在后面
***本次分享是首次,不好的地方还请谅解，还望多多指正！！！***

###本次分享代码地址
>https://github.com/wuyinlei/RetrofitTest


  [1]: https://github.com/ReactiveX/RxJava
  [2]: http://gank.io/post/560e15be2dca930e00da1083#toc_1
  [3]: http://blog.csdn.net/lzyzsd/article/details/41833541
  [4]: http://blog.csdn.net/lzyzsd/article/details/44094895
  [5]: http://blog.csdn.net/lzyzsd/article/details/44891933
  [6]: http://blog.csdn.net/lzyzsd/article/details/45033611
  [7]: http://reactivex.io/documentation/operators.html
  [8]: http://www.codexiu.cn/android/blog/32382/
  [9]: http://www.jianshu.com/p/9c3b4ea108a7
  [10]: http://www.jianshu.com/p/731799dc04de
  [11]: https://gold.xitu.io/entry/5825300b2f301e005c47fac5
  [12]: http://lliuguangbo.github.io/2016/10/06/okhttp%E6%8B%A6%E6%88%AA%E5%99%A8/
  [13]: https://github.com/cn-ljb/rxjava_for_android
  [14]: http://gank.io/post/56e80c2c677659311bed9841