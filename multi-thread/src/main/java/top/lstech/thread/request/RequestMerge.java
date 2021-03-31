package top.lstech.thread.request;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @Author: 义云
 * @Date: 2020/6/15 12:30 PM
 * @Version 1.0
 */
public class RequestMerge {

    /**
     * 请求合并并转发，比如： 把5秒内的所有的请求合并在一起请求，并把请求结果分发
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    static class Request {
        String code;
        CompletableFuture<Integer> future;
    }

    private LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();


    // @PostConstruct
    public void init() {
        Executors.newSingleThreadScheduledExecutor()
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            int size = queue.size();
            if (size == 0) {
                System.out.println("队列中没有请求");
                return;
            }
            List<Request> requests = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Request request = queue.poll();
                requests.add(request);
            }
            System.out.println("合并了" + size + "个请求");
            //List<BankInfo> bankInfos = bankInfoMapperExt.selectList(new QueryWrapper<>());
//            //Map<String, BankInfo> map = bankInfos.stream().collect(Collectors.toMap(BankInfo::getId, x -> x));
//            for (Request request : requests) {
//                BankInfo bankInfo = map.get(request.code);
//                request.future.complete(bankInfo);
//            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    public Integer query(String code) throws ExecutionException, InterruptedException {
        Request request = new Request();
        request.code = code;
        CompletableFuture<Integer> future = new CompletableFuture<>();
        request.future = future;
        queue.add(request);
        return future.get();
    }
}
