package com.seydaozdemir.concurrency.A_threadsafety.threadcreation.producerconsumer;

public class ProducerConsumerPattern {
    /**
     * The producer consumer pattern is a workload distribution pattern where the number of work executing
     * threads is decoupled from the number of tasks these worker threads are to execute.
     * Örneğin dosya yapısındaki pek çok dosya web uygulamasına upload edilecek. Eğer bu işi bir thread'le
     * gerçekleştirmeye kalkarsak, birden çok core a sahip cpu kullanıyorsak, dezavantajlı bir durum ortaya çıkar.
     * Bunun yerine dosyaları yükleyen birden çok thread yapısı varsa bu durumda işlem verimli olur.
     * Eğer her bir dosyayı belirlemek için yeni bir thread açarsak ve 1000 tane dosyamız olduğunu düşünürsek,
     * bu işlem için 1000 thread açmamız gerekir. Ve böylece her thread belirli miktarda sistem kaynağı tüketir.
     * Örneğin ram kaynağı. Bu durumda sistem kaynaklarını gereksiz yere tüketmiş oluruz. Bunun yerine bir thread ile
     * dosyaları belirleyip bir BlokingQueue'a eklersek. Kuyruğun diğer ucuna bir ya da daha fazla thread ile kuyruktaki
     * dosyaları tek tek sisteme upload edersek, bütün operasyonu daha verimli bir şekilde gerçekleştirebiliriz.
     *
     * -Producer Consumer kullanıldığı noktalar
     *  * Reduce foreground thread latency (main thread'in bir işlemle uğraşmak yerine işi kuyruğa ve dolaysıyla
     *  başka bir thread'e devretmesi sayesinde uygulamanın cevap vermeye devam etmesi.)
     *  Aynı şekilde eğer multithreaded bir server uygulaması gelen istekleri bir thread üzerinden işlemeye kalkarsa
     *  uygulama bir noktada takılabilir. Bu yaklaşımla istek karşılandıktan sonra kuyruya alınır ve başka thread'lere
     *  iş devredilir, dolaysıyla main thread işlemin bitmesini beklemez.
     *  * Load balance between worker threads
     *  Elimizdeki işe göre consumer threadlerin sayısını kullandığımız makinenin core sayısına göre ayarlarız.
     *  Bu sayede gereksiz threadlerle server'a overload fazla yük yüklememiş oluyoruz. Eğer cpu sayısı kadar
     *  worker thread kullanılırsa elde edilecek işlem verimi maximum düzeyde olur. 
     *  * Backpressure management
     *  Backpressure ön yüzden-clienttan sisteme çok fazla istek gitmesi durumunda kuyruk hemen dolacaktır, kuyrukta
     *  işlenmek üzere yeni bir istek kuyruğa alınamayacaktır. Arka tarafta çalışan worker threadler ön tarafta istekleri
     *  karşılayan bölüme backpressure uygulayacaktır. İstekleri karşılayan thread arka tarafta çalışan threadlerin
     *  daha fazla istek alamayacağını bilir. Böylece ön tarafta istekleri karşılayan thread istek almayı bir süre bırakır.
     *  En azından kuyruk biraz boşalana ve yer açılana kadar.
     */
}
