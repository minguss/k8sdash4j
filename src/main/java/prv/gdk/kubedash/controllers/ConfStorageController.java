package prv.gdk.kubedash.controllers;


import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("confstorage")
public class ConfStorageController {

  @RequestMapping(value = "/configmap", method = RequestMethod.GET)
  public String configmap(){
    return "confstorage/configmap";
  }

  @RequestMapping(value = "/configmap/list", method = RequestMethod.GET)
  public ModelAndView getConfigmapList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listConfigMapForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/pvc", method = RequestMethod.GET)
  public String pvc(){
    return "confstorage/pvc";
  }

  @RequestMapping(value = "/pvc/list", method = RequestMethod.GET)
  public ModelAndView getPvcList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listPersistentVolumeClaimForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/secret", method = RequestMethod.GET)
  public String secret(){
    return "confstorage/secret";
  }

  @RequestMapping(value = "/secret/list", method = RequestMethod.GET)
  public ModelAndView getSecretList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listSecretForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

}
