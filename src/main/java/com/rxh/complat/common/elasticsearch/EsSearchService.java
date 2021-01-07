package com.rxh.complat.common.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rxh.wechat.entity.SysUser;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @Description: ES操作类
 * @Author Zhang YuHui 
 * @Date 2020/11/24 17:08
 *
 */
@Service
public class EsSearchService {
    @Autowired
    RestHighLevelClient highLevelClient;

//    @Bean
//    public RestHighLevelClient restHighLevelClient(){
//        RestClientBuilder build = RestClient.builder(
//                new HttpHost("127.0.0.1", 9200, "http")
//        );
//        return new RestHighLevelClient(build);
//    }

    /**
     * @Description createIndex
     * @author Zhang YuHui
     * @date 2020/11/25 11:32
     *
     * @params inxName 索引名
     * @params pian 分片数量
     * @params bei 备份分片
     * @params ananlyzer 默认分词器
     * @return boolean
     */
    public boolean createIndex(String inxName, String pian, String backup,String ananlyzer) throws IOException {

        Settings.Builder builder = Settings.builder()
                .put("number_of_shards", pian)
                .put("number_of_replicas", backup)
                .put("analysis.analyzer.default.type",ananlyzer);
        XContentBuilder object = JsonXContent.contentBuilder().startObject()
                .startObject("properties")
                .startObject("name").field("type", "text").field("analyzer", "pinyin").endObject()
                .startObject("text").field("type", "text").field("analyzer", "ik_max_word").endObject()
                .endObject()
                .endObject();
        CreateIndexRequest indexRequest = new CreateIndexRequest(inxName).settings(builder).mapping(object);
        CreateIndexResponse response = highLevelClient.indices().create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>" + response);
        return response.isAcknowledged();

    }

    public Object delIndex(String... idxName) throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest();
        deleteIndexRequest.indices(idxName);
        AcknowledgedResponse delete = highLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        return delete.isAcknowledged();
    }

    public Object createDoc(String index, EsEnyity user) throws IOException {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id(user.getId());
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse index1 = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index1.getResult().toString());
        return index1;
    }

    public Object updateDoc(String index, Map<String, Object> map, String id) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(index, id);
        updateRequest.doc(map);
        UpdateResponse update = highLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        return update.getResult().toString();
    }

    public Object delDoc(String index, String docId) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index);
        deleteRequest.id(docId);
        DeleteResponse delete = highLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        return delete.getResult().toString();
    }

    public Object getDoc(String index, String docId) throws IOException {
        GetRequest getRequest = new GetRequest(index);
        getRequest.id(docId);
        GetResponse documentFields = highLevelClient.get(getRequest, RequestOptions.DEFAULT);
        return documentFields;
    }

    public Object query(String index, String fild, String value, String size) throws IOException, NoSuchFieldException, IllegalAccessException {
        //精确查询
//        QueryBuilder builder = QueryBuilders.termQuery(fild,value);
        //类似模糊查询
        QueryBuilder builder = QueryBuilders.matchQuery(fild, value);

        //关键字高亮展示
        String preTags = "<font color=\"red\">";
        String postTags = "</font>";
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(fild);
        highlightBuilder.preTags(preTags);
        highlightBuilder.postTags(postTags);

        //设置查询相关信息
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(builder).highlighter(highlightBuilder);
        sourceBuilder.size(Integer.parseInt(size));

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices(index);
        searchRequest.source(sourceBuilder);
        SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        ArrayList<EsEnyity> list = new ArrayList<>();
        for (SearchHit hit : search.getHits()) {
            EsEnyity esEnyity = JSONObject.parseObject(hit.getSourceAsString(), EsEnyity.class);
            list.add(esEnyity);
            //获取查询得到的高亮字段,通过反射加入类中
            Text fragment = hit.getHighlightFields().get(fild).getFragments()[0];
            esEnyity.getClass().getDeclaredField(fild).set(esEnyity,fragment.toString());
            System.out.println(fragment.toString());
        }
        return list;
    }

//    public Object queryPin(String index, String fild, String value, String size, String targes) throws IOException {
//        QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery(fild, value)
//                .fuzziness(Fuzziness.TWO)
//                .prefixLength(0)
//                .maxExpansions(Integer.parseInt(size));
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.field(fild);
////        highlightBuilder.preTags(targes);
//        highlightBuilder.preTags();
//        highlightBuilder.postTags();
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(queryBuilder);
//        SearchRequest searchRequest = new SearchRequest(index);
//        searchRequest.source(sourceBuilder);
//        SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        ArrayList<EsEnyity> list = new ArrayList<>();
//
//        ArrayList<String> list1 = new ArrayList<>();
//        for (SearchHit hit : search.getHits()) {
//            EsEnyity esEnyity = JSONObject.parseObject(hit.getSourceAsString(), EsEnyity.class);
//            list.add(esEnyity);
//            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
////            Text fragment = hit.getHighlightFields().get(fild).getFragments()[0];
////            list1.add(fragment.toString());
//            System.out.println(hit);
//            System.out.println(hit.getSourceAsString());
//        }
//        return list1;
//
//    }
}
