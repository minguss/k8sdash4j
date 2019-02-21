package prv.gdk.kubedash.controllers;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.AppsV1beta2Api;
import io.kubernetes.client.apis.BatchV1Api;
import io.kubernetes.client.apis.BatchV1beta1Api;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/workload")
public class WorkloadController {

  @RequestMapping(value = "/cronjob", method = RequestMethod.GET)
  public String cronjob(){
    return "workload/cronjob";
  }

  @RequestMapping(value = "/cronjob/list", method = RequestMethod.GET)
  public ModelAndView getCronjobList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    BatchV1beta1Api api = new BatchV1beta1Api();

    Call call = api.listCronJobForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/daemonset", method = RequestMethod.GET)
  public String daemonset(){
    return "workload/daemonset";
  }

  @RequestMapping(value = "/daemonset/list", method = RequestMethod.GET)
  public ModelAndView getDaemonsetList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    AppsV1beta2Api api = new AppsV1beta2Api();

    Call call = api.listDaemonSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/deployment", method = RequestMethod.GET)
  public String deployment(){
    return "workload/deployment";
  }

  @RequestMapping(value = "/deployment/list", method = RequestMethod.GET)
  public ModelAndView getDeploymentList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    AppsV1beta2Api api = new AppsV1beta2Api();

    Call call = api.listDeploymentForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/job", method = RequestMethod.GET)
  public String job(){
    return "workload/job";
  }

  @RequestMapping(value = "/job/list", method = RequestMethod.GET)
  public ModelAndView getJobList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    BatchV1Api api = new BatchV1Api();

    Call call = api.listJobForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/pod", method = RequestMethod.GET)
  public String pod(){
    return "workload/pod";
  }

  @RequestMapping(value = "/pod/list", method = RequestMethod.GET)
  public ModelAndView getPodList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listPodForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/replicaset", method = RequestMethod.GET)
  public String replicaset(){
    return "workload/replicaset";
  }

  @RequestMapping(value = "/replicaset/list", method = RequestMethod.GET)
  public ModelAndView getReplicasetList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    AppsV1beta2Api api = new AppsV1beta2Api();

    Call call = api.listReplicaSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/replication", method = RequestMethod.GET)
  public String replication(){
    return "workload/replicationcontroller";
  }

  @RequestMapping(value = "/replication/list", method = RequestMethod.GET)
  public ModelAndView getReplicationList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listReplicationControllerForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/statefulset", method = RequestMethod.GET)
  public String statefulset(){
    return "workload/statefulset";
  }

  @RequestMapping(value = "/statefulset/list", method = RequestMethod.GET)
  public ModelAndView getStatefulsetList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    AppsV1beta2Api api = new AppsV1beta2Api();

    Call call = api.listStatefulSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }
}
