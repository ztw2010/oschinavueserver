package com.vueoschina.cn.openapi;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vueoschina.cn.bean.BaseRequestBean;
import com.vueoschina.cn.bean.BlogDetailBean;
import com.vueoschina.cn.bean.CommentListRequestBean;
import com.vueoschina.cn.bean.NewsDetailRequestBean;
import com.vueoschina.cn.bean.NewsDetailResponseBean;
import com.vueoschina.cn.bean.NewsListRequestBean;
import com.vueoschina.cn.bean.NewsType0ResponseBean;
import com.vueoschina.cn.bean.NewsType3ResponseBean;
import com.vueoschina.cn.bean.PubCommentRequestBean;
import com.vueoschina.cn.bean.TokenRequestBean;
import com.vueoschina.cn.bean.error.ErrorBean;
import com.vueoschina.cn.bean.favorite.FavoriteRequestBean;
import com.vueoschina.cn.bean.follow.FollowRequestBean;
import com.vueoschina.cn.bean.mine.MineInfoRequestBean;
import com.vueoschina.cn.bean.mine.MineInfoResponseBean;
import com.vueoschina.cn.bean.mine.MsgListRequestBean;
import com.vueoschina.cn.bean.mine.UserBlogBean;
import com.vueoschina.cn.bean.mine.UserBlogListRequestBean;
import com.vueoschina.cn.bean.mine.UserBlogListResponseBean;
import com.vueoschina.cn.bean.tweet.ActivelistBean;
import com.vueoschina.cn.bean.tweet.MineTweetListRequestBean;
import com.vueoschina.cn.bean.tweet.MineTweetResponseBean;
import com.vueoschina.cn.bean.tweet.TweetListRequestBean;
import com.vueoschina.cn.bean.type2.NewsType2ResponseBean;
import com.vueoschina.cn.bean.type2.Type2ReplyBean;
import com.vueoschina.cn.bean.type2.Type2TagBean;
import com.vueoschina.cn.bean.type7.NewsType7ResponseBean;

public class TokenServlet extends HttpServlet {

	private static final long serialVersionUID = -1614368850799013613L;

	private ObjectMapper objectMapper;

	private final String userAgent = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36";

	@Override
	public void init() throws ServletException {
		super.init();
		objectMapper = new ObjectMapper();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		BufferedReader reader = request.getReader();
		StringBuffer jb = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null)
			jb.append(line);
		String content = jb.toString();
		System.out.println("request content=" + content);
		BaseRequestBean requestBean = objectMapper.readValue(content, BaseRequestBean.class);
		String requestMethod = requestBean.getMethodName();
		if (BaseRequestBean.METHOD_GETTOKEN.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<TokenRequestBean> baseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, TokenRequestBean.class));
			getToken(request, response, baseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_GETGETMULTIPLE.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<NewsListRequestBean> baseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, NewsListRequestBean.class));
			getMultipleNews(request, response, baseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_NEWSDETAIL.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<NewsDetailRequestBean> baseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, NewsDetailRequestBean.class));
			getNewsDetail(request, response, baseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_PUBCOMMENT.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<PubCommentRequestBean> puBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, PubCommentRequestBean.class));
			pubComment(request, response, puBaseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_GETCOMMENTLIST.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<CommentListRequestBean> baseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, CommentListRequestBean.class));
			getCommentList(request, response, baseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_GETTWEETLIST.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<TweetListRequestBean> twBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, TweetListRequestBean.class));
			getTweetList(request, response, twBaseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_GETMINEINFO.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<MineInfoRequestBean> minBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, MineInfoRequestBean.class));
			getMineInfo(request, response, minBaseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_FAVORITE_LIST.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<FavoriteRequestBean> faBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, FavoriteRequestBean.class));
			getFavoriteList(request, response, faBaseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_FOLLOW_LIST.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<FollowRequestBean> foBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, FollowRequestBean.class));
			getFollowList(request, response, foBaseRequestBean.getT());
		} else if (BaseRequestBean.METHOD_ACTIVE_LIST.equalsIgnoreCase(requestMethod)) {
			BaseRequestBean<MineTweetListRequestBean> miBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, MineTweetListRequestBean.class));
			getMineTweetList(request, response, miBaseRequestBean.getT());
		} else if(BaseRequestBean.METHOD_MESSAGE_LIST.equalsIgnoreCase(requestMethod)){
			BaseRequestBean<MsgListRequestBean> msBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, MsgListRequestBean.class));
			getMsgList(request, response, msBaseRequestBean.getT());
		} else if(BaseRequestBean.METHOD_USER_BLOG_LIST.equalsIgnoreCase(requestMethod)){
			BaseRequestBean<UserBlogListRequestBean> usBaseRequestBean = objectMapper.readValue(content,
					getCollectionType(BaseRequestBean.class, UserBlogListRequestBean.class));
			getUserBlogList(request, response, usBaseRequestBean.getT());
		}
	}

	private JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	private void getToken(HttpServletRequest request, HttpServletResponse response, TokenRequestBean tokenRequestBean)
			throws JsonParseException, JsonMappingException, IOException {
		if (tokenRequestBean != null) {
			URL url = new URL("https://www.oschina.net/action/openapi/token");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(request.getMethod());
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setReadTimeout(20 * 1000);
			conn.setConnectTimeout(20 * 1000);
			StringBuilder sbBuilder = new StringBuilder();
			sbBuilder.append("client_id=");
			sbBuilder.append(tokenRequestBean.getClientId());
			sbBuilder.append("&");
			sbBuilder.append("client_secret=");
			sbBuilder.append(tokenRequestBean.getClientSecret());
			sbBuilder.append("&");
			sbBuilder.append("grant_type=");
			sbBuilder.append(tokenRequestBean.getGrantType());
			sbBuilder.append("&");
			sbBuilder.append("redirect_uri=");
			sbBuilder.append(tokenRequestBean.getRedirectUri());
			sbBuilder.append("&");
			sbBuilder.append("code=");
			sbBuilder.append(tokenRequestBean.getCode());
			sbBuilder.append("&");
			sbBuilder.append("dataType=");
			sbBuilder.append(tokenRequestBean.getDataType());
			String requestContent = sbBuilder.toString();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 必须加上User-Agent否则去访问API时服务器会直接拒绝
			conn.setRequestProperty("User-Agent", userAgent);
			conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(requestContent.getBytes());
			outputStream.flush();
			int code = conn.getResponseCode();
			String result = "";
			if (code == 200) {
				InputStream is = conn.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int len = 0;
				byte buffer[] = new byte[1024];
				while ((len = is.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				is.close();
				baos.close();
				result = new String(baos.toByteArray(), "UTF-8");
			} else {
				ErrorBean errorBean = new ErrorBean();
				errorBean.setErrorCode(code);
				errorBean.setErrorMsg(conn.getResponseMessage());
				result = objectMapper.writeValueAsString(errorBean);
			}
			System.out.println("getToken result=" + result);
			PrintWriter out = response.getWriter();
			out.append(result);
		}
	}

	private void getMultipleNews(HttpServletRequest request, HttpServletResponse response,
			NewsListRequestBean newsListRequestBean) throws JsonParseException, JsonMappingException, IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/news_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(newsListRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("catalog=");
		sbBuilder.append(newsListRequestBean.getCatalog());
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(newsListRequestBean.getPage());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(newsListRequestBean.getPageSize());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(newsListRequestBean.getDataType());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getMultipleNews result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getNewsDetail(HttpServletRequest request, HttpServletResponse response,
			NewsDetailRequestBean newsDetailRequestBean) throws IOException {
		String result = "";
		String newsUrl = newsDetailRequestBean.getNewsUrl();
		int type = newsDetailRequestBean.getNewsType();
		if (newsUrl != null && !"".equals(newsUrl)) {
			result = parseNewsDetail(type, newsUrl, new NewsDetailResponseBean());
		} else {
			URL url = new URL("https://www.oschina.net/action/openapi/news_detail");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(request.getMethod());
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setReadTimeout(20 * 1000);
			conn.setConnectTimeout(20 * 1000);
			StringBuilder sbBuilder = new StringBuilder();
			sbBuilder.append("access_token=");
			sbBuilder.append(newsDetailRequestBean.getAccessToken());
			sbBuilder.append("&");
			sbBuilder.append("id=");
			sbBuilder.append(newsDetailRequestBean.getId());
			sbBuilder.append("&");
			sbBuilder.append("dataType=");
			sbBuilder.append(newsDetailRequestBean.getDataType());
			String requestContent = sbBuilder.toString();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("User-Agent", userAgent);
			conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(requestContent.getBytes());
			outputStream.flush();
			int code = conn.getResponseCode();
			if (code == 200) {
				InputStream is = conn.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int len = 0;
				byte buffer[] = new byte[1024];
				while ((len = is.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				is.close();
				baos.close();
				result = new String(baos.toByteArray(), "UTF-8");
				System.out.println("original newsDetail result=" + result);
				if (result != null && !"".equals(result) && type != 4) {
					NewsDetailResponseBean newsDetailResponseBean = objectMapper.readValue(result,
							NewsDetailResponseBean.class);
					String originalUrl = newsDetailResponseBean.getUrl();
					result = parseNewsDetail(type, originalUrl, newsDetailResponseBean);
				}
			} else {
				ErrorBean errorBean = new ErrorBean();
				errorBean.setErrorCode(code);
				errorBean.setErrorMsg(conn.getResponseMessage());
				result = objectMapper.writeValueAsString(errorBean);
			}
		}
		System.out.println("getNewsDetail result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private String parseNewsDetail(int type, String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		switch (type) {
		case NewsDetailRequestBean.TYPE_0:
			result = parseNewsDetailType0(originalUrl, newsDetailResponseBean);
			break;
		case NewsDetailRequestBean.TYPE_1:
			result = parseNewsDetailType1(originalUrl, newsDetailResponseBean);
			break;
		case NewsDetailRequestBean.TYPE_2:
			result = parseNewsDetailType2(originalUrl, newsDetailResponseBean);
			break;
		case NewsDetailRequestBean.TYPE_3:
			result = parseNewsDetailType3(originalUrl, newsDetailResponseBean);
			break;
		case NewsDetailRequestBean.TYPE_4:

			break;
		case NewsDetailRequestBean.TYPE_7:
			result = parseNewsDetailType7(originalUrl, newsDetailResponseBean);
			break;
		default:
			break;
		}
		return result;
	}

	private String parseNewsDetailType7(String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		Connection connectionType7 = Jsoup.connect(originalUrl).timeout(2 * 1000 * 1000);
		connectionType7.header("User-Agent", userAgent);
		Document document7 = null;
		NewsType7ResponseBean type7ResponseBean = new NewsType7ResponseBean();
		try {
			document7 = connectionType7.get();
			document7.setBaseUri("https://www.oschina.net/");
			Element element = document7.select("h1.title-status").first();
			if (element != null) {
				Node childNode = element.childNode(0);
				if (childNode != null && childNode instanceof TextNode) {
					type7ResponseBean.setTitle(((TextNode) childNode).text());
				}
			}
			element = document7.select("span.reply_count").first();
			if (element != null) {
				String commentCount = element.text();
				if (commentCount != null) {
					type7ResponseBean.setCommentCount(Integer.valueOf(commentCount));
				}
			}
			type7ResponseBean.setPubDate(newsDetailResponseBean.getPubDate());
			type7ResponseBean.setNotice(newsDetailResponseBean.getNotice());
			element = document7.select("a.mr").first();
			if (element != null) {
				type7ResponseBean.setAuthor(element.text());
			}
			Elements elements = document7.select("li.page > a[href]");
			if (elements != null && !elements.isEmpty()) {
				elements.remove(elements.size() - 1);// 移除掉下一页按钮
				if (!elements.isEmpty()) {
					StringBuilder builder = new StringBuilder();
					for (Element curElement : elements) {
						String pageUrl = curElement.attr("href");
						String body = parseNewsType7PageBody(originalUrl + pageUrl);
						builder.append(body);
					}
					type7ResponseBean.setBody(builder.toString());
				}
			}
			result = objectMapper.writeValueAsString(type7ResponseBean);
			System.out.println("type7ResponseBean=" + result);
		} catch (Exception e) {

		}
		return result;
	}

	private String parseNewsDetailType3(String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		Connection connectionType3 = Jsoup.connect(originalUrl).timeout(2 * 1000 * 1000);
		connectionType3.header("User-Agent", userAgent);
		Document document3 = null;
		NewsType3ResponseBean type3Bean = new NewsType3ResponseBean();
		try {
			document3 = connectionType3.get();
			document3.setBaseUri("https://www.oschina.net/");
			Element element = document3.select("img.LargePortrait").first();
			if (element != null) {
				String imgUrl = element.attr("src");
				type3Bean.setImageUrl(imgUrl);
			}
			element = document3.select("a.name").first();
			if (element != null) {
				String title = element.text();
				type3Bean.setTitle(title);
			}
			type3Bean.setPubDate(newsDetailResponseBean.getPubDate());
			element = document3.select("span[data-fansid]").first();
			if (element != null) {
				String title = element.text();
				if (title != null) {
					if (title.contains("+ 关注")) {
						type3Bean.setIsWatched(0);
					} else if (title.contains("已关注")) {
						type3Bean.setIsWatched(1);
					}
				} else {
					type3Bean.setIsWatched(0);
				}
			}
			element = document3.select("span.original").first();
			if (element != null) {
				type3Bean.setIsOriginal(1);
			} else {
				type3Bean.setIsOriginal(0);
			}
			element = document3.select("span.recommend").first();
			if (element != null) {
				type3Bean.setIsRecommend(1);
			} else {
				type3Bean.setIsRecommend(0);
			}
			element = document3.select("div.title").first();
			if (element != null) {
				List<Node> nodes = element.childNodes();
				if (nodes != null && !nodes.isEmpty()) {
					Node lastNode = nodes.get(nodes.size() - 1);
					if (lastNode instanceof TextNode) {
						String blogTitle = ((TextNode) lastNode).text();
						type3Bean.setBlogTitle(blogTitle);
					}
				}
			}
			element = document3.select("div.clearfix").first();
			if (element != null) {
				String blogBody = element.html();
				type3Bean.setBody(blogBody);
			}
			type3Bean.setRerelativies(newsDetailResponseBean.getRelativies());
			element = document3.getElementById("comment");
			if (element != null) {
				String commentCount = element.text();
				type3Bean.setCommentCount(Integer.valueOf(commentCount));
			}
			type3Bean.setNotice(newsDetailResponseBean.getNotice());
		} catch (IOException e) {

		}
		try {
			result = objectMapper.writeValueAsString(type3Bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("type3Bean=" + result);
		return result;
	}

	private String parseNewsDetailType2(String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		Connection connectionType2 = Jsoup.connect(originalUrl).timeout(2 * 1000 * 1000);
		connectionType2.header("User-Agent", userAgent);
		Document document2 = null;
		NewsType2ResponseBean type2Bean = new NewsType2ResponseBean();
		try {
			document2 = connectionType2.get();
			document2.setBaseUri("https://www.oschina.net/");
			Element element = document2.select("span.question-title-link").first();
			if (element != null) {
				String title = element.text();
				type2Bean.setTitle(title);
			}
			element = document2.select("div.toolbar_tags").first();// 解析tags
			if (element != null) {
				List<Type2TagBean> type2TagBeans = new ArrayList<Type2TagBean>();
				List<Node> nodes = element.childNodes();
				if (nodes != null && !nodes.isEmpty()) {// 说明有tag
					Elements tagElements = document2.select("a[data-id]");
					if (tagElements != null && !tagElements.isEmpty()) {
						for (Element elementTag : tagElements) {
							Type2TagBean type2TagBean = new Type2TagBean();
							type2TagBean.setTagName(elementTag.text());
							type2TagBeans.add(type2TagBean);
						}
					}
					if (!type2TagBeans.isEmpty()) {
						type2Bean.setTagBeans(type2TagBeans);
					}
				}
			}
			element = document2.select("section.clearfix").first();
			if (element != null) {
				type2Bean.setBody(element.html());
			}
			element = document2.select("a.author-name").first();
			if (element != null) {
				type2Bean.setAuthor(element.text());
			}
			type2Bean.setPubDate(newsDetailResponseBean.getPubDate());
			Elements allChildElements = document2.select("article.answer_list > section");
			if (allChildElements != null && !allChildElements.isEmpty()) {// 有回答
				Elements userImages = document2.select("a.user_img > img.SmallPortrait");// 所有回答者头像地址
				Elements userNames = document2.select("a.user_name");// 所有回答者名字
				Elements replyTimes = document2.select("div.reply-time");// 所有回答者时间
				Elements answers = document2.select("header.answer_detail > p");// 所有回答者内容
				if (allChildElements != null) {
					type2Bean.setCommentCount(allChildElements.size());
					List<Type2ReplyBean> replyBeans = new ArrayList<Type2ReplyBean>();
					for (int i = 0; i < allChildElements.size(); i++) {
						Type2ReplyBean type2ReplyBean = new Type2ReplyBean();
						type2ReplyBean.setImageUrl(userImages.get(i).attr("src"));
						type2ReplyBean.setTitle(userNames.get(i).text());
						type2ReplyBean.setPubDate(replyTimes.get(i).attr("title"));
						type2ReplyBean.setBody(answers.get(i).text());
						replyBeans.add(type2ReplyBean);
					}
					type2Bean.setReplyBeans(replyBeans);
				}
			}
		} catch (Exception e) {

		}
		type2Bean.setRerelativies(newsDetailResponseBean.getRelativies());
		type2Bean.setNotice(newsDetailResponseBean.getNotice());
		try {
			result = objectMapper.writeValueAsString(type2Bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("type2Bean=" + result);
		return result;
	}

	private String parseNewsDetailType0(String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		Connection connectionType0 = Jsoup.connect(originalUrl).timeout(2 * 1000 * 1000);
		connectionType0.header("User-Agent", userAgent);
		Document document0 = null;
		try {
			document0 = connectionType0.get();
			Element element = document0.select("div.tree-content").first();
			element = document0.select("div#git-readme").first();
			if (element != null) {
				newsDetailResponseBean.setBody(element.html());
			}
		} catch (Exception e) {

		}
		try {
			result = objectMapper.writeValueAsString(newsDetailResponseBean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("type0Bean=" + result);
		return result;
	}

	private String parseNewsDetailType1(String originalUrl, NewsDetailResponseBean newsDetailResponseBean) {
		String result = "";
		Connection connection = Jsoup.connect(originalUrl).timeout(2 * 1000 * 1000);
		connection.header("User-Agent", userAgent);
		Document document = null;
		NewsType0ResponseBean type0Bean = new NewsType0ResponseBean();
		try {
			document = connection.get();
			document.setBaseUri("https://www.oschina.net/");
			Elements elements = document.select("span.logo > img");
			if (elements != null && !elements.isEmpty()) {
				String imageUrl = elements.iterator().next().attr("src");
				type0Bean.setImageUrl(document.baseUri() + imageUrl);
			}
			elements = document.select("div.box-aw > a > h1");
			if (elements != null && !elements.isEmpty()) {
				String title1 = elements.iterator().next().text();
				type0Bean.setTitle(title1);
			}
			elements = document.select("div.collect-num > span.num");
			if (elements != null && !elements.isEmpty()) {
				String favoriteCount = elements.iterator().next().text();
				if (favoriteCount == null || "".equals(favoriteCount)) {
					favoriteCount = "0";
				}
				type0Bean.setFavoriteCount(Integer.valueOf(favoriteCount));
			}
			elements = document.select("span.box-aw > a > span");
			if (elements != null && !elements.isEmpty()) {
				String commentCount = elements.iterator().next().text();
				if (commentCount == null || "".equals(commentCount)) {
					commentCount = "0";
				}
				type0Bean.setCommentCount(Integer.valueOf(commentCount));
			}
			elements = document.select("div.all");
			if (elements != null && !elements.isEmpty()) {
				String body = elements.iterator().next().html();
				if (body == null) {
					body = "暂无内容";
				}
				type0Bean.setBody(body);
			}
			type0Bean.setFavorite(newsDetailResponseBean.getFavorite());
			type0Bean.setNotice(newsDetailResponseBean.getNotice());
			type0Bean.setRerelativies(newsDetailResponseBean.getRelativies());
		} catch (IOException e) {

		}
		try {
			result = objectMapper.writeValueAsString(type0Bean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("type0Bean=" + result);
		return result;
	}

	private String parseNewsType7PageBody(String pageUrl) {
		Connection connectionType7 = Jsoup.connect(pageUrl).timeout(2 * 1000 * 1000);
		connectionType7.header("User-Agent", userAgent);
		Document document7 = null;
		try {
			document7 = connectionType7.get();
			document7.setBaseUri("https://www.oschina.net/");
			Elements elements = document7.select("div.paragraph-container > div.content");
			if (elements != null && !elements.isEmpty()) {
				StringBuilder builder = new StringBuilder();
				for (Element curElement : elements) {
					builder.append(curElement.html());
				}
				return builder.toString();
			}
		} catch (Exception e) {

		}
		return "";
	}

	private void pubComment(HttpServletRequest request, HttpServletResponse response,
			PubCommentRequestBean pubCommentRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/blog_comment_pub");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(pubCommentRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("blog=");
		sbBuilder.append(pubCommentRequestBean.getNewsId());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(pubCommentRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("content=");
		sbBuilder.append(pubCommentRequestBean.getContent());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("pubComment result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getCommentList(HttpServletRequest request, HttpServletResponse response,
			CommentListRequestBean commentListRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/comment_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("catalog=");
		sbBuilder.append(1);
		sbBuilder.append("&");
		sbBuilder.append("access_token=");
		sbBuilder.append(commentListRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("id=");
		sbBuilder.append(commentListRequestBean.getId());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(commentListRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("pageIndex=");
		sbBuilder.append(commentListRequestBean.getPageIndex());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(commentListRequestBean.getPageSize());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getCommentList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getTweetList(HttpServletRequest request, HttpServletResponse response,
			TweetListRequestBean tweetListRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/tweet_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("user=");
		sbBuilder.append(tweetListRequestBean.getUser());
		sbBuilder.append("&");
		sbBuilder.append("access_token=");
		sbBuilder.append(tweetListRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(tweetListRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("pageIndex=");
		sbBuilder.append(tweetListRequestBean.getPageIndex());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(tweetListRequestBean.getPageSize());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getTweetList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getMineInfo(HttpServletRequest request, HttpServletResponse response,
			MineInfoRequestBean mineInfoRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/my_information");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(mineInfoRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(mineInfoRequestBean.getDataType());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
			MineInfoResponseBean mineInfoResponseBean = objectMapper.readValue(result, MineInfoResponseBean.class);
			Object object = getMineTweetResponseBean(mineInfoRequestBean.getAccessToken(),
					mineInfoRequestBean.getDataType(), 1, 1000, 4, mineInfoResponseBean.getUid(), true);
			if (object instanceof MineTweetResponseBean) {
				MineTweetResponseBean mineTweetResponseBean = (MineTweetResponseBean) object;
				List<ActivelistBean> activelistBeans = mineTweetResponseBean.getActivelist();
				if (activelistBeans != null) {
					mineInfoResponseBean.setTweetCount(activelistBeans.size());
				}
			}
			result = objectMapper.writeValueAsString(mineInfoResponseBean);
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getMineInfo result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getFavoriteList(HttpServletRequest request, HttpServletResponse response,
			FavoriteRequestBean favoriteRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/favorite_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(favoriteRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(favoriteRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(favoriteRequestBean.getPage());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(favoriteRequestBean.getPageSize());
		sbBuilder.append("&");
		sbBuilder.append("type=");
		sbBuilder.append(favoriteRequestBean.getType());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getFavoriteList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getFollowList(HttpServletRequest request, HttpServletResponse response,
			FollowRequestBean followRequestBean) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/friends_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(followRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(followRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(followRequestBean.getPage());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(followRequestBean.getPageSize());
		sbBuilder.append("&");
		sbBuilder.append("relation=");
		sbBuilder.append(followRequestBean.getRelation());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getFollowList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private void getMineTweetList(HttpServletRequest request, HttpServletResponse response,
			MineTweetListRequestBean mineTweetListRequestBean) throws IOException {
		Object object = getMineTweetResponseBean(mineTweetListRequestBean.getAccessToken(),
				mineTweetListRequestBean.getDataType(), mineTweetListRequestBean.getPage(),
				mineTweetListRequestBean.getPageSize(), mineTweetListRequestBean.getCatalog(),
				mineTweetListRequestBean.getUser(), false);
		String result = objectMapper.writeValueAsString(object);
		System.out.println("getMineTweetList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}

	private Object getMineTweetResponseBean(String access_token, String dataType, int page, int pageSize, int catalog,
			int user, boolean isMinInfo) throws IOException {
		URL url = new URL("https://www.oschina.net/action/openapi/active_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(access_token);
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(dataType);
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(page);
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(pageSize);
		sbBuilder.append("&");
		sbBuilder.append("catalog=");
		sbBuilder.append(catalog);
		sbBuilder.append("&");
		sbBuilder.append("user=");
		sbBuilder.append(user);
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			return errorBean;
		}
		MineTweetResponseBean mineTweetResponseBean = objectMapper.readValue(result, MineTweetResponseBean.class);
		List<ActivelistBean> activelist = mineTweetResponseBean.getActivelist();
		if (isMinInfo) {
			List<ActivelistBean> mineTweetList = new ArrayList<ActivelistBean>();
			if (activelist != null && !activelist.isEmpty()) {
				for (ActivelistBean activelistBean : activelist) {
					if (100 == activelistBean.getObjectType()) {
						mineTweetList.add(activelistBean);
					}
				}
				mineTweetResponseBean.setActivelist(mineTweetList);
			}
		}
		return mineTweetResponseBean;
	}
	
	private void getMsgList(HttpServletRequest request, HttpServletResponse response,
			MsgListRequestBean msgListRequestBean) throws IOException{
		URL url = new URL("https://www.oschina.net/action/openapi/message_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(msgListRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(msgListRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(msgListRequestBean.getPage());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(msgListRequestBean.getPageSize());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getMsgList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}
	
	private void getUserBlogList(HttpServletRequest request, HttpServletResponse response,
			UserBlogListRequestBean userBlogListRequestBean)throws IOException{
		URL url = new URL("https://www.oschina.net/action/openapi/user_blog_list");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(request.getMethod());
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(userBlogListRequestBean.getAccessToken());
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append(userBlogListRequestBean.getDataType());
		sbBuilder.append("&");
		sbBuilder.append("authoruid=");
		sbBuilder.append(userBlogListRequestBean.getAuthoruId());
		sbBuilder.append("&");
		sbBuilder.append("page=");
		sbBuilder.append(userBlogListRequestBean.getPage());
		sbBuilder.append("&");
		sbBuilder.append("pageSize=");
		sbBuilder.append(userBlogListRequestBean.getPageSize());
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
			UserBlogListResponseBean responseBean = objectMapper.readValue(result, UserBlogListResponseBean.class);
			List<UserBlogBean> list = responseBean.getProjectlist();
			if(list != null && !list.isEmpty()){
				for (UserBlogBean userBlogBean : list) {
					String body = getBlogBody(userBlogBean.getId(), userBlogListRequestBean.getAccessToken());
					userBlogBean.setBody(body);
				}
			}
			result = objectMapper.writeValueAsString(responseBean);
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		System.out.println("getUserBlogList result=" + result);
		PrintWriter out = response.getWriter();
		out.append(result);
	}
	
	private String getBlogBody(Long blogId, String accessToken) throws IOException{
		URL url = new URL("https://www.oschina.net/action/openapi/blog_detail");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setReadTimeout(20 * 1000);
		conn.setConnectTimeout(20 * 1000);
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("access_token=");
		sbBuilder.append(accessToken);
		sbBuilder.append("&");
		sbBuilder.append("id=");
		sbBuilder.append(blogId);
		sbBuilder.append("&");
		sbBuilder.append("dataType=");
		sbBuilder.append("json");
		String requestContent = sbBuilder.toString();
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("User-Agent", userAgent);
		conn.setRequestProperty("Content-Length", String.valueOf(requestContent.length()));
		OutputStream outputStream = conn.getOutputStream();
		outputStream.write(requestContent.getBytes());
		outputStream.flush();
		int code = conn.getResponseCode();
		String result = "";
		if (code == 200) {
			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			is.close();
			baos.close();
			result = new String(baos.toByteArray(), "UTF-8");
			BlogDetailBean detailBean = objectMapper.readValue(result, BlogDetailBean.class);
			result = detailBean.getBody();
		} else {
			ErrorBean errorBean = new ErrorBean();
			errorBean.setErrorCode(code);
			errorBean.setErrorMsg(conn.getResponseMessage());
			result = objectMapper.writeValueAsString(errorBean);
		}
		return result;
	}

	@Override
	public void destroy() {
		super.destroy();
		objectMapper = null;
	}
}
