package prv.gdk.kubedash.controllers;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Response;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.AppsV1beta2Api;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/disload")
public class DisLoadController {

  @RequestMapping(value = "/ingress", method = RequestMethod.GET)
  public String ingress(){
    return "disload/ingress";
  }

  @RequestMapping(value = "/ingress/list", method = RequestMethod.GET)
  public ModelAndView getIngressList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    ExtensionsV1beta1Api api = new ExtensionsV1beta1Api();

    Call call = api.listIngressForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }

  @RequestMapping(value = "/service", method = RequestMethod.GET)
  public String service(){
    return "disload/service";
  }

  @RequestMapping(value = "/service/list", method = RequestMethod.GET)
  public ModelAndView getServiceList() throws IOException, ApiException {
    ModelAndView modelAndView = new ModelAndView("jsonView");
    ApiClient client = Config.defaultClient();
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    Call call = api.listServiceForAllNamespacesCall(null, null, null, null, null, null, null, 5, false,  null, null);



    Response response = call.execute();

    if (!response.isSuccessful()) {
      modelAndView.addObject("result", "error!");
      return modelAndView;
    }

    modelAndView.addObject("result",response.body().string());

    return modelAndView;
  }
}
