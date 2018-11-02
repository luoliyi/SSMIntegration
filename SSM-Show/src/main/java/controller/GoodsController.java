package controller;

import MyUtils.Standard;
import com.nf.luoliyi.entities.Goods;
import com.nf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.*;

@Controller
@RequestMapping(path = "/goodsController")
public class GoodsController {

    /*
    * 自动封装对象
    * */
    @Autowired
    GoodsService goodsService;

    /*
    * 获取总商品数量
    * */
    @RequestMapping(path = "/getAllGoodsCount",method = RequestMethod.POST)
    @ResponseBody
    public int getAllGoodsCount(){
        return goodsService.queryAllGoods().size();
    }

    /*
    * 分页查询
    * */
    @RequestMapping(path ="/queryAllGoodsByPage",method = RequestMethod.POST)
    @ResponseBody
    public List<Goods> queryAllGoodsByPage(@RequestBody List<Integer> intList){
        return goodsService.selectAllGoodsByPage(intList.get(0),intList.get(1));
    }

    /*
    * 查询全部商品
    * */
    @RequestMapping(path = "/queryGoods",method = RequestMethod.POST)
    @ResponseBody
    public List<Goods> queryGoods(Model model){
       return goodsService.queryAllGoods();
    }

    @RequestMapping(path = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public Object insert(@RequestBody Goods goods){

        System.out.println(goods);

       int result= goodsService.insert(goods);
       if(result>0){
           return goodsService.queryAllGoods();
       }
        return "新增失败。";
    }

    /*
    * 更新
    * */
    @ResponseBody
    @RequestMapping( path = "/update",method = RequestMethod.POST)
    public Object update(@RequestBody Goods goods){
        int result= goodsService.update(goods);
        if(result>0){
            return goodsService.queryAllGoods();
        }
        return "更新失败。";
    }

    /*
    * 删除
    * */
    @ResponseBody
    @RequestMapping(path = "/delete",method = RequestMethod.POST)
    public Object delete(@RequestBody Integer id){
        int result= goodsService.delete(id);
        if(result>0){
            return goodsService.queryAllGoods();
        }
        return "删除失败。";
    }

    /*
    * 批量删除
    * */
    @ResponseBody
    @RequestMapping(path = "/deleteAll",method = RequestMethod.POST)
    public Object deleteAll(@RequestBody List<Integer> items){
        System.out.println(items);
        int result=goodsService.deleteAll(items);
        if(result>0){
            return goodsService.queryAllGoods();
        }
        return "批量删除失败。";
    }


    /*
    * 文件上传
    *
    * */
    @RequestMapping(value = "/fileSave",method = RequestMethod.POST)
    @ResponseBody
    public Standard fileSave(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //文件存放的位置
        String path=request.getServletContext().getRealPath("/image");
        File fi=new File(path);
        if(!fi.exists()){
            fi.mkdir();
        }
        File tempFile=new File(path, file.getOriginalFilename());
        file.transferTo(tempFile);
        System.out.println(tempFile.getName());
        Standard standard=new Standard();
        standard.put("msg","上传成功!");
        standard.put("data",tempFile.getName());

        return standard;
    }
}