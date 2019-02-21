package prv.gdk.kubedash.controllers;


import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.*;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

  @RequestMapping(value = "/overview", method = RequestMethod.GET)
  public String overview(){
    return "overview";
  }

  @RequestMapping(value = "/overview/load", method = RequestMethod.GET)
  public ModelAndView overviewLoad() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");

    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    AppsV1beta2Api api = new AppsV1beta2Api();
    BatchV1beta1Api beta1Api = new BatchV1beta1Api();
    BatchV1Api dV1Api = new BatchV1Api();
    CoreV1Api coreV1Api = new CoreV1Api();
    ExtensionsV1beta1Api exV1Api = new ExtensionsV1beta1Api();


    Map<String, Call> calls = new HashMap<>();


    calls.put("cronjob", beta1Api.listCronJobForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("daemonset", api.listDaemonSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("deployment", api.listDeploymentForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("job", dV1Api.listJobForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("replicaset", api.listReplicaSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("replication", coreV1Api.listReplicationControllerForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("statefulset", api.listStatefulSetForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("pod", coreV1Api.listPodForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("service", coreV1Api.listServiceForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("ingress", exV1Api.listIngressForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("configmap", coreV1Api.listConfigMapForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("pvc",coreV1Api.listPersistentVolumeClaimForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));
    calls.put("secret",coreV1Api.listSecretForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null));

    for(Map.Entry<String, Call> entry : calls.entrySet()){
      Response response = entry.getValue().execute();

      if (!response.isSuccessful()) {
        modelAndView.addObject(entry.getKey(), "error!");
      }else{
        modelAndView.addObject(entry.getKey(),response.body().string());
      }
    }





    return modelAndView;
  }



}
