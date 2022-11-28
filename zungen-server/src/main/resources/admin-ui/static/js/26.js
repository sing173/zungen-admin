(window["webpackJsonp"] = window["webpackJsonp"] || []).push([[26],{

/***/ "./src/api/system/dict/type.js":
/*!*************************************!*\
  !*** ./src/api/system/dict/type.js ***!
  \*************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
eval("\n\nvar _interopRequireDefault = __webpack_require__(/*! ./node_modules/@babel/runtime/helpers/interopRequireDefault.js */ \"./node_modules/@babel/runtime/helpers/interopRequireDefault.js\").default;\n\nObject.defineProperty(exports, \"__esModule\", {\n  value: true\n});\nexports.addType = addType;\nexports.delType = delType;\nexports.exportType = exportType;\nexports.getType = getType;\nexports.listAllSimple = listAllSimple;\nexports.listType = listType;\nexports.updateType = updateType;\n\nvar _request = _interopRequireDefault(__webpack_require__(/*! @/utils/request */ \"./src/utils/request.js\"));\n\n// 查询字典类型列表\nfunction listType(query) {\n  return (0, _request.default)({\n    url: '/system/dict-type/page',\n    method: 'get',\n    params: query\n  });\n} // 查询字典类型详细\n\n\nfunction getType(dictId) {\n  return (0, _request.default)({\n    url: '/system/dict-type/get?id=' + dictId,\n    method: 'get'\n  });\n} // 新增字典类型\n\n\nfunction addType(data) {\n  return (0, _request.default)({\n    url: '/system/dict-type/create',\n    method: 'post',\n    data: data\n  });\n} // 修改字典类型\n\n\nfunction updateType(data) {\n  return (0, _request.default)({\n    url: '/system/dict-type/update',\n    method: 'put',\n    data: data\n  });\n} // 删除字典类型\n\n\nfunction delType(dictId) {\n  return (0, _request.default)({\n    url: '/system/dict-type/delete?id=' + dictId,\n    method: 'delete'\n  });\n} // 导出字典类型\n\n\nfunction exportType(query) {\n  return (0, _request.default)({\n    url: '/system/dict-type/export',\n    method: 'get',\n    params: query,\n    responseType: 'blob'\n  });\n} // 获取字典选择框列表\n\n\nfunction listAllSimple() {\n  return (0, _request.default)({\n    url: '/system/dict-type/list-all-simple',\n    method: 'get'\n  });\n}\n\n//# sourceURL=webpack:///./src/api/system/dict/type.js?");

/***/ }),

/***/ "./src/utils/constants.js":
/*!********************************!*\
  !*** ./src/utils/constants.js ***!
  \********************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
eval("\n\nObject.defineProperty(exports, \"__esModule\", {\n  value: true\n});\nexports.SystemUserSocialTypeEnum = exports.SystemRoleTypeEnum = exports.SystemMenuTypeEnum = exports.SystemDataScopeEnum = exports.PayType = exports.PayRefundStatusEnum = exports.PayOrderStatusEnum = exports.PayOrderRefundStatusEnum = exports.PayOrderNotifyStatusEnum = exports.PayChannelEnum = exports.InfraJobStatusEnum = exports.InfraCodegenTemplateTypeEnum = exports.InfraApiErrorLogProcessStatusEnum = exports.CommonStatusEnum = void 0;\n\n/**\n * Created by admin\n *\n * 枚举类\n */\n\n/**\n * 全局通用状态枚举\n */\nvar CommonStatusEnum = {\n  ENABLE: 0,\n  // 开启\n  DISABLE: 1 // 禁用\n\n};\n/**\n * 菜单的类型枚举\n */\n\nexports.CommonStatusEnum = CommonStatusEnum;\nvar SystemMenuTypeEnum = {\n  DIR: 1,\n  // 目录\n  MENU: 2,\n  // 菜单\n  BUTTON: 3 // 按钮\n\n};\n/**\n * 角色的类型枚举\n */\n\nexports.SystemMenuTypeEnum = SystemMenuTypeEnum;\nvar SystemRoleTypeEnum = {\n  SYSTEM: 1,\n  // 内置角色\n  CUSTOM: 2 // 自定义角色\n\n};\n/**\n * 数据权限的范围枚举\n */\n\nexports.SystemRoleTypeEnum = SystemRoleTypeEnum;\nvar SystemDataScopeEnum = {\n  ALL: 1,\n  // 全部数据权限\n  DEPT_CUSTOM: 2,\n  // 指定部门数据权限\n  DEPT_ONLY: 3,\n  // 部门数据权限\n  DEPT_AND_CHILD: 4,\n  // 部门及以下数据权限\n  DEPT_SELF: 5 // 仅本人数据权限\n\n};\n/**\n * 代码生成模板类型\n */\n\nexports.SystemDataScopeEnum = SystemDataScopeEnum;\nvar InfraCodegenTemplateTypeEnum = {\n  CRUD: 1,\n  // 基础 CRUD\n  TREE: 2,\n  // 树形 CRUD\n  SUB: 3 // 主子表 CRUD\n\n};\n/**\n * 任务状态的枚举\n */\n\nexports.InfraCodegenTemplateTypeEnum = InfraCodegenTemplateTypeEnum;\nvar InfraJobStatusEnum = {\n  INIT: 0,\n  // 初始化中\n  NORMAL: 1,\n  // 运行中\n  STOP: 2 // 暂停运行\n\n};\n/**\n * API 异常数据的处理状态\n */\n\nexports.InfraJobStatusEnum = InfraJobStatusEnum;\nvar InfraApiErrorLogProcessStatusEnum = {\n  INIT: 0,\n  // 未处理\n  DONE: 1,\n  // 已处理\n  IGNORE: 2 // 已忽略\n\n};\n/**\n * 用户的社交平台的类型枚举\n */\n\nexports.InfraApiErrorLogProcessStatusEnum = InfraApiErrorLogProcessStatusEnum;\nvar SystemUserSocialTypeEnum = {\n  DINGTALK: {\n    title: \"钉钉\",\n    type: 20,\n    source: \"dingtalk\",\n    img: \"https://cdn.jsdelivr.net/gh/justauth/justauth-oauth-logo@1.11/dingtalk.png\"\n  },\n  WECHAT_ENTERPRISE: {\n    title: \"企业微信\",\n    type: 30,\n    source: \"wechat_enterprise\",\n    img: \"https://cdn.jsdelivr.net/gh/justauth/justauth-oauth-logo@1.11/wechat_enterprise.png\"\n  }\n};\n/**\n * 支付渠道枚举\n */\n\nexports.SystemUserSocialTypeEnum = SystemUserSocialTypeEnum;\nvar PayChannelEnum = {\n  WX_PUB: {\n    \"code\": \"wx_pub\",\n    \"name\": \"微信 JSAPI 支付\"\n  },\n  WX_LITE: {\n    \"code\": \"wx_lite\",\n    \"name\": \"微信小程序支付\"\n  },\n  WX_APP: {\n    \"code\": \"wx_app\",\n    \"name\": \"微信 APP 支付\"\n  },\n  ALIPAY_PC: {\n    \"code\": \"alipay_pc\",\n    \"name\": \"支付宝 PC 网站支付\"\n  },\n  ALIPAY_WAP: {\n    \"code\": \"alipay_wap\",\n    \"name\": \"支付宝 WAP 网站支付\"\n  },\n  ALIPAY_APP: {\n    \"code\": \"alipay_app\",\n    \"name\": \"支付宝 APP 支付\"\n  },\n  ALIPAY_QR: {\n    \"code\": \"alipay_qr\",\n    \"name\": \"支付宝扫码支付\"\n  }\n};\n/**\n * 支付类型枚举\n */\n\nexports.PayChannelEnum = PayChannelEnum;\nvar PayType = {\n  WECHAT: \"WECHAT\",\n  ALIPAY: \"ALIPAY\"\n};\n/**\n * 支付订单状态枚举\n */\n\nexports.PayType = PayType;\nvar PayOrderStatusEnum = {\n  WAITING: {\n    status: 0,\n    name: '未支付'\n  },\n  SUCCESS: {\n    status: 10,\n    name: '已支付'\n  },\n  CLOSED: {\n    status: 20,\n    name: '未支付'\n  }\n};\n/**\n * 支付订单回调状态枚举\n */\n\nexports.PayOrderStatusEnum = PayOrderStatusEnum;\nvar PayOrderNotifyStatusEnum = {\n  NO: {\n    status: 0,\n    name: '未通知'\n  },\n  SUCCESS: {\n    status: 10,\n    name: '通知成功'\n  },\n  FAILURE: {\n    status: 20,\n    name: '通知失败'\n  }\n};\n/**\n * 支付订单退款状态枚举\n */\n\nexports.PayOrderNotifyStatusEnum = PayOrderNotifyStatusEnum;\nvar PayOrderRefundStatusEnum = {\n  NO: {\n    status: 0,\n    name: '未退款'\n  },\n  SOME: {\n    status: 10,\n    name: '部分退款'\n  },\n  ALL: {\n    status: 20,\n    name: '全部退款'\n  }\n};\n/**\n * 支付退款订单状态枚举\n */\n\nexports.PayOrderRefundStatusEnum = PayOrderRefundStatusEnum;\nvar PayRefundStatusEnum = {\n  CREATE: {\n    status: 0,\n    name: '退款订单生成'\n  },\n  SUCCESS: {\n    status: 1,\n    name: '退款成功'\n  },\n  FAILURE: {\n    status: 2,\n    name: '退款失败'\n  },\n  PROCESSING_NOTIFY: {\n    status: 3,\n    name: '退款中，渠道通知结果'\n  },\n  PROCESSING_QUERY: {\n    status: 4,\n    name: '退款中，系统查询结果'\n  },\n  UNKNOWN_RETRY: {\n    status: 5,\n    name: '状态未知，请重试'\n  },\n  UNKNOWN_QUERY: {\n    status: 6,\n    name: '状态未知，系统查询结果'\n  },\n  CLOSE: {\n    status: 99,\n    name: '退款关闭'\n  }\n};\nexports.PayRefundStatusEnum = PayRefundStatusEnum;\n\n//# sourceURL=webpack:///./src/utils/constants.js?");

/***/ })

}]);