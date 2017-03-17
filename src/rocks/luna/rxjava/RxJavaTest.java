package rocks.luna.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by cyuan on 3/5/17.
 */
public class RxJavaTest {

    @Test
    public void test() {
        String[] strs = {"abc", "Def", " hijk"};

        Observable.unsafeCreate(s -> {
            s.onNext("Hello World");
            s.onCompleted();
        }).subscribe(System.out::println);

        Observable<Integer> o = Observable.unsafeCreate(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onCompleted();
        });

        o.map(i -> "Number " + i).subscribe(System.out::println);

        // Dangerous!!! Do NOT do this!!
        Observable.unsafeCreate(s -> {
            new Thread(() -> {
                s.onNext("one");
                s.onNext("two");
            }).start();

            new Thread(() -> {
                s.onNext("three");
                s.onNext("four");
            }).start();
        }).subscribe(System.out::println);
    }

    @Test
    public void testObservableMerge() {
        Observable<String> a = Observable.unsafeCreate(s -> {
            new Thread(() -> {
                s.onNext("one");
                s.onNext("two");
                s.onCompleted();
            }).start();

        });

        Observable<String> b = Observable.unsafeCreate(s -> {
            new Thread(() -> {
                s.onNext("three");
                s.onNext("four");
                s.onCompleted();
            }).start();
        });

        Observable<String> c = Observable.merge(a, b);
    }

    @Test
    public void testSubscriber() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String str) {
                if (str.contains("java")) {
                    unsubscribe();
                }
                System.out.println(str);
            }
        };

        Observable<String> o = Observable.unsafeCreate(s -> {
            s.onNext("Hello");
            s.onNext("World");
            s.onNext("java");
            s.onNext("8");
            s.onNext("new");
            s.onNext("feature");
        });

        o.subscribe(subscriber);
    }

    @Test
    public void testScheduler() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
                .observeOn(Schedulers.newThread()) // 指定 Subscriber 的回调发生在主线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        System.out.println("number:" + number);
                    }
                });
    }

    @Test
    public void testLift() {
        Observable.just(1, 2, 3, 4).lift(new Observable.Operator<String, Integer>() {
            @Override
            public Subscriber<? super Integer> call(final Subscriber<? super String> subscriber) {
                // 将事件序列中的 Integer 对象转换为 String 对象
                return new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        subscriber.onNext("" + integer);
                    }

                    @Override
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        subscriber.onError(e);
                    }
                };
            }
        });
    }
}
