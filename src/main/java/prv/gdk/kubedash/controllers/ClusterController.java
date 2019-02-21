package prv.gdk.kubedash.controllers;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.apis.RbacAuthorizationV1beta1Api;
import io.kubernetes.client.apis.StorageV1beta1Api;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1NamespaceList;
import io.kubernetes.client.util.Config;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/cluster")
public class ClusterController {

  @RequestMapping(value = "/namespace", method = RequestMethod.GET)
  public String namespace(){
    return "cluster/namespace";
  }

  @RequestMapping(value = "/namespace/list", method = RequestMethod.GET)
  public ModelAndView getNamespaceList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listNamespaceCall(null, null, null, null, null, null, null, 5, false,  null, null);

    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }



  @RequestMapping(value = "/node", method = RequestMethod.GET)
  public String node(){
    return "cluster/node";
  }

  @RequestMapping(value = "/node/list", method = RequestMethod.GET)
  public ModelAndView getNodeList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listNodeCall(null, null, null, null, null, null, null, 5, false,  null, null);


    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/pv", method = RequestMethod.GET)
  public String pv(){
    return "cluster/pv";
  }

  @RequestMapping(value = "/pv/list", method = RequestMethod.GET)
  public ModelAndView getPvList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listPersistentVolumeCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/role", method = RequestMethod.GET)
  public String role(){
    return "cluster/role";
  }

  @RequestMapping(value = "/role/list", method = RequestMethod.GET)
  public ModelAndView getRoleList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);


    RbacAuthorizationV1beta1Api api = new RbacAuthorizationV1beta1Api();

    Call call = api.listRoleForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);
    Call callForCluster = api.listClusterRoleCall(null, null, null, null, null, null, null, 5, false,  null, null);

    Response response = call.execute();
    Response responseForCluster = callForCluster.execute();

    if (!(response.isSuccessful() && responseForCluster.isSuccessful())) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());
    modelAndView.addObject("result2",responseForCluster.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/storageclass", method = RequestMethod.GET)
  public String storageclass(){
    return "cluster/storageclass";
  }

  @RequestMapping(value = "/storageclass/list", method = RequestMethod.GET)
  public ModelAndView getStorageclassList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);


    StorageV1beta1Api api = new StorageV1beta1Api();

    Call call = api.listStorageClassCall(null, null, null, null, null, null, null, 5, false,  null, null);

    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }
}
