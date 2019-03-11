package com.lian.dq.xiaosx.beans;

import java.util.List;

public class ListDemo {

    /**
     * image_title : GC
     * image_dis : {"tilte":"AndroidGC机制","top":"GC里面的算法","botm":"GC的使用"}
     * image_list : [{"time_date":"网易科技  07：44","image_url":"http://106.13.63.54:8080/sys/image/b.jpg","image_content":"具有强引用的对象不会被GC；即便内存空间不足，JVM宁愿抛出OutOfMemoryError使程序异常终止，也不会随意回收具有强引用的对象"},{"time_date":"网易科技  07：45","image_url":"http://106.13.63.54:8080/sys/image/c.jpg","image_content":"只具有软引用的对象，会在内存空间不足的时候被GC，如果回收之后内存仍不足，才会抛出OOM异常；软引用常用于描述有用但并非必需的对象，比如实现内存敏感的高速缓存。"},{"time_date":"网易科技  07：46","image_url":"http://106.13.63.54:8080/sys/image/d.jpg","image_content":"只被弱引用关联的对象，无论当前内存是否足够都会被GC；强度比软引用更弱，常用于描述非必需对象"},{"time_date":"网易科技  07：47","image_url":"http://106.13.63.54:8080/sys/image/e.jpg","image_content":"仅持有虚引用的对象，在任何时候都可能被GC；常用于跟踪对象被GC回收的活动；必须和引用队列 （ReferenceQueue）联合使用，当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。"},{"time_date":"网易科技  07：48","image_url":"http://106.13.63.54:8080/sys/image/f.jpg","image_content":"引用计数算法：给对象中添加一个引用计数器，每当有一个地方引用它时，计数器值就加1；当引用失效时，计数器值就减1；任何时刻计数器为0的对象就是不可能再被使用的。"},{"time_date":"网易科技  07：49","image_url":"http://106.13.63.54:8080/sys/image/g.jpg","image_content":"然而在主流的Java虚拟机里未选用引用计数算法来管理内存，主要原因是它难以解决对象之间相互循环引用的问题，所以出现了另一种对象存活判定算法。"},{"time_date":"网易科技  07：50","image_url":"http://106.13.63.54:8080/sys/image/h.jpg","image_content":"b.可达性分析法：通过一系列被称为『GC Roots』的对象作为起始点，从这些节点开始向下搜索，搜索所走过的路径称为引用链，当一个对象到GC Roots没有任何引用链相连时，则证明此对象是不可用的。"},{"time_date":"网易科技  07：51","image_url":"http://106.13.63.54:8080/sys/image/i.jpg","image_content":"可作为GC Roots的对象：虚拟机栈中引用的对象，主要是指栈帧中的本地变量本地方法栈中Native方法引用的对象方法区中类静态属性引用的对象方法区中常量引用的对象"},{"time_date":"网易科技  07：52","image_url":"http://106.13.63.54:8080/sys/image/j.jpg","image_content":"需要注意的是，在可达性分析算法中被判定不可达的对象还未真的判『死刑』，至少要经历两次标记过程：判断对象是否有必要执行finalize()方法；若被判定为有必要执行finalize()方法，之后还会对对象再进行一次筛选，如果对象能在finalize()中重新与引用链上的任何一个对象建立关联，将被移除出\u201c即将回收\u201d的集合。"},{"time_date":"网易科技  07：53","image_url":"http://106.13.63.54:8080/sys/image/k.jpg","image_content":"引伸：有关方法区的GC，可分成两部分废弃常量与回收Java堆中的对象的GC很类似，即在任何地方都未被引用的常量会被GC。"},{"time_date":"网易科技  07：54","image_url":"http://106.13.63.54:8080/sys/image/l.jpg","image_content":"无用的类需满足以下三个条件才会被GC：该类所有的实例都已被回收，即Java堆中不存在该类的任何实例；加载该类的ClassLoader已经被回收；该类对应的java.lang.Class对象没在任何地方被引用，即无法在任何地方通过反射访问该类的方法。"},{"time_date":"网易科技  07：55","image_url":"http://106.13.63.54:8080/sys/image/m.jpg","image_content":"垃圾收集算法：上一节介绍了JVM会回收哪些对象，接下来介绍JVM会如何回收掉这些对象"},{"time_date":"网易科技  07：56","image_url":"http://106.13.63.54:8080/sys/image/n.jpg","image_content":"a.分代收集算法根据对象存活周期的不同，将Java堆划分为新生代和老年代，并根据各个年代的特点采用最适当的收集算法。新生代：大批对象死去，只有少量存活。使用『复制算法』，只需复制少量存活对象即可。老年代：对象存活率高。使用『标记\u2014清理算法』或者『标记\u2014整理算法』，只需标记较少的回收对象即可。是当前商业虚拟机都采用的一种算法。"},{"time_date":"网易科技  07：57","image_url":"http://106.13.63.54:8080/sys/image/o.jpg","image_content":"b.复制算法把可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存用尽后，把还存活着的对象『复制』到另外一块上面，再将这一块内存空间一次清理掉。优点：每次都是对整个半区进行内存回收，无需考虑内存碎片等复杂情况，只要移动堆顶指针，按顺序分配内存即可，实现简单，运行高效。缺点：每次可使用的内存缩小为原来的一半，内存使用率低。"},{"time_date":"网易科技  07：58","image_url":"http://106.13.63.54:8080/sys/image/p.jpg","image_content":"有研究表明新生代中的对象98%是朝生夕死的，因此没必要按照1:1来划分内存空间，而是分为一块较大的Eden空间和两块较小的Survivor空间，在HotSpot虚拟机中默认比例为8:1:1。每次使用Eden和一块Survivor，回收时将这两块中存活着的对象一次性地复制到另外一块Survivor上，再做清理。可见只有10%的内存会被\u201c浪费\u201d，倘若Survivor空间不足还需要依赖其他内存（老年代）进行分配担保。"},{"time_date":"网易科技  07：59","image_url":"http://106.13.63.54:8080/sys/image/q.jpg","image_content":"标记-清除算法 首先『标记』出所有需要回收的对象，然后统一『清除』所有被标记的对象。是最基础的收集算法"},{"time_date":"网易科技  07：60","image_url":"http://106.13.63.54:8080/sys/image/r.jpg","image_content":"缺点：『标记』和『清除』过程的效率不高；空间碎片太多，『标记』『清除』之后会产生大量不连续的内存碎片，可能会导致后续需要分配较大对象时，因无法找到足够的连续内存而提前触发另一次GC，影响系统性能。"}]
     */

    private String image_title;
    private ImageDisBean image_dis;
    private List<ImageListBean> image_list;

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public ImageDisBean getImage_dis() {
        return image_dis;
    }

    public void setImage_dis(ImageDisBean image_dis) {
        this.image_dis = image_dis;
    }

    public List<ImageListBean> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<ImageListBean> image_list) {
        this.image_list = image_list;
    }

    public static class ImageDisBean {
        /**
         * tilte : AndroidGC机制
         * top : GC里面的算法
         * botm : GC的使用
         */

        private String tilte;
        private String top;
        private String botm;

        public String getTilte() {
            return tilte;
        }

        public void setTilte(String tilte) {
            this.tilte = tilte;
        }

        public String getTop() {
            return top;
        }

        public void setTop(String top) {
            this.top = top;
        }

        public String getBotm() {
            return botm;
        }

        public void setBotm(String botm) {
            this.botm = botm;
        }
    }

    public static class ImageListBean {
        /**
         * time_date : 网易科技  07：44
         * image_url : http://106.13.63.54:8080/sys/image/b.jpg
         * image_content : 具有强引用的对象不会被GC；即便内存空间不足，JVM宁愿抛出OutOfMemoryError使程序异常终止，也不会随意回收具有强引用的对象
         */

        private String time_date;
        private String image_url;
        private String image_content;

        public String getTime_date() {
            return time_date;
        }

        public void setTime_date(String time_date) {
            this.time_date = time_date;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_content() {
            return image_content;
        }

        public void setImage_content(String image_content) {
            this.image_content = image_content;
        }
    }
}
