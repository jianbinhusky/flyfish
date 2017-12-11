
var source_qsingle = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" disp_type="${disp_type}" cols_count="${column_count}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled {@if disp_type === \"transverse\" || disp_type === \"column\"}cols_ul{@/if}">{@each question.option_list as option}<li style="{@if disp_type === \'column\'}width:${col_width};{@/if}"><input type="radio" name="radio" id="option_${option._id.$oid}" value="option_${option._id.$oid}"><label class="T_edit_min" for="" name="option" id="${option._id.$oid}">$${option.title}</label>{@if option.is_open}<input type="text" name="" id="" class="open_input">{@/if}</li>{@/each}</ul><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="clone-icon-active"></i></a></div></div></div></li>';
var source_qsingle_dropdown = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" disp_type="${disp_type}" cols_count="${column_count}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title">$${question.title}</div></div><div class="drop_zon"><select class="drop_down" id="drop_down_${qmodel.qid}">{@each question.option_list as option}<option>$${option.title}</option>{@/each}</select><a class="bj_drop" href="javascript:;">编辑选项</a></div><ul class="unstyled xllist" style="display:none;" id="invisible_${qmodel.qid}">{@each question.option_list as option}<li><label name="option" class="T_edit_min" for="" id="${option._id.$oid}">$${option.title}</label></li>{@/each}</ul><div class="bj_drop_xl"><div class="operationH"><a href="javascript:;" class="cq_add"><i class="add-icon-active"></i></a><a class="Bub" href="javascript:;"><i class="clone-icon-active"></i></a><a class="bj_drop_achieve" href="javascript:;">完成编辑</a></div></div></div></div></li>';
var source_qmultiple = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" disp_type="${disp_type}" cols_count="${column_count}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="q_title th4 T_edit" name="question">$${question.title}</div></div><ul class="unstyled {@if disp_type === \"transverse\" || disp_type === \"column\"}cols_ul{@/if}">{@each question.option_list as option}<li style="{@if disp_type === \'column\'}width:${col_width};{@/if}"><input type="checkbox" name="radio" value="${option._id.$oid}"><label class="T_edit_min" name="option" id="${option._id.$oid}">$${option.title}</label>{@if option.is_open}<input type="text" name="" id="" class="open_input">{@/if}</li>{@/each}</ul><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></div></div></li>';
var source_qblank = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i  class="up-icon-active"></i></a><a class="down_cq" href="javascript:;"><i  class="down-icon-active"></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled"><li style="overflow:inherit"><div class="option_Fill" id="${question.option_list[0]._id.$oid}"><div class="min_an" style="display: none;"><i></i></div>{@if question.custom_attr.blank_type}{@if question.custom_attr.blank_type === "single"}<input type="text" style="width: ${parseInt(question.option_list[0].custom_attr.text_col) * 15}px;" value="" name="" />{@else}<textarea class="" type="text" rows="${question.option_list[0].custom_attr.text_row}" cols="${parseInt(question.option_list[0].custom_attr.text_col) * 2}"></textarea>{@/if}{@else}<textarea class="" type="text" rows="${question.option_list[0].custom_attr.text_row}" cols="${parseInt(question.option_list[0].custom_attr.text_col) * 2}"></textarea>{@/if}</div></li></ul></div></div></li>';
var source_qblank_dropdown = '<li oid="${qmodel.qid}" issue="${question.question_type}" class="module question" id="question_${qmodel.qid}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4>Q1</h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="q_title th4 T_edit">$${question.title}</div></div>{@if question.custom_attr.drop_type === \'address\'}<div class="selectTransverse">{@each i in range(0, question.option_list.length-1)}<select id="${question.option_list[i]._id.$oid}" ><option value="">请选择${question.option_list[i].title}</option></select>{@/each}<br><textarea style="margin-top:10px;width: 358px;" name="" id="${question.option_list[3]._id.$oid}" style="width:380px;height:100px;" placeholder="街道信息"></textarea></div>{@else}<div class="selectTransverse">{@each question.option_list as option}<select id="${option._id.$oid}" ><option value="">请选择${option.title}</option></select>{@/each}</div>{@/if}</div></div></li><script type="text/javascript">var qmodel_${question.cid} = get_qmodel("${question._id.$oid}");setTimeout(function(){qmodel_${question.cid}.bind_drop();}, 20);{@if question.custom_attr.drop_type === \'address\'}inputVal("#${question.option_list[3]._id.$oid}");{@/if}</script>';
var source_qscore = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" minnum="${question.custom_attr.min_answer_num}" maxnum="${question.custom_attr.max_answer_num}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><div class="grade"><table cellpadding="0" cellspacing="0"><thead><tr><td>&nbsp;</td><td><table style="width:400px; margin-left:20px;"><td style="width:116px;">{@if question.custom_attr.desc_left}$${question.custom_attr.desc_left}{@else}&nbsp;{@/if}</td><td align="center" style="width:116px;">{@if question.custom_attr.desc_middle}$${question.custom_attr.desc_middle}{@else}&nbsp;{@/if}</td><td align="right" style="width:116px;">{@if question.custom_attr.desc_right}$${question.custom_attr.desc_right}{@else}&nbsp;{@/if}</td><td width="50"></td></table></td></tr></thead><tbody>{@each question.option_list as option}<tr class="Ed_tr"><td id="${option._id.$oid}" name="option" align="right" class="T_edit_td">$${option.title}</td><td><table style="width:400px;"><tbody><tr><td><div class="grade_text"><table cellspacing="0" cellpadding="1" border="0" class="topic_ul"><tbody><tr>{@each i in range(parseInt(question.custom_attr.min_answer_num), parseInt(question.custom_attr.max_answer_num) + 1)}<td class="div_float">${i}</td>{@/each}</tr></tbody></table></div></td><td width="30" align="right">分</td></tr></tbody></table></td></tr>{@/each}</tbody></table></div><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></div></div></li>';
var source_qorder = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" {@if \'limit_sort_count\' in question.custom_attr}limit="${question.custom_attr.limit_sort_count}"{@/if}><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><div class="pxul"><ul class="unstyled Sorting">{@each question.option_list as option}<li><label class="T_edit_min" name="option" id="${option._id.$oid}">$${option.title}</label></li>{@/each}</ul><div class="sort-right"><table class="table2"><tbody>{@if question.custom_attr.limit_sort_count}{@each i in range(1, parseInt(question.custom_attr.limit_sort_count) + 1)}<tr><th class="w28">${i}</th><td>&nbsp;</td></tr>{@/each}{@else}{@each i in range(1, question.option_list.length + 1)}<tr><th class="w28">${i}</th><td>&nbsp;</td></tr>{@/each}{@/if}</tbody></table></div></div><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub"  style="display: none;"><i class="clone-icon-active"></i></a></div><p class="mt10">请将左面的项拖放到右面的框完成排序</p></div></div></li>';
var source_qmultiple_blank = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><div class="grade"><table><tbody>{@each question.option_list as option}<tr class="Ed_tr"><td align="right" class="T_edit_td" name="option" id="${option._id.$oid}">$${option.title}</td><td><div class="grade_text" style="width:500px;"><textarea id="option_${option._id.$oid}" rows="${option.custom_attr.text_row}" cols="${parseInt(option.custom_attr.text_col) * 2}"></textarea></div></td></tr>{@/each}</tbody></table></div><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></div></div></li>';
var source_qmatrix_single = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled"><li><div class="matrix" style="min-height: 60px;"><table class="table table-bordered td-Tc" cellspacing="0" cellpadding="0"><tbody><tr><td>&nbsp;</td>{@each question.option_list as option}<td class="T_edit_td" name="option" id="${option._id.$oid}" menutype="col" {@if option.is_open}is_open="1"{@/if}>$${option.title}</td>{@/each}</tr>{@each question.matrixrow_list as row}<tr class="Ed_tr"><td class="T_edit_td" id="${row._id.$oid}" style="text-align:left;" name="row" menutype="row">$${row.title}</td>{@each question.option_list as option}<td><input type="radio" name="">{@if option.is_open}<input type="text" name="" id="" class="open_input">{@/if}</td>{@/each}</tr>{@/each}</tbody></table></div><div class="operationV"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></li><li><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a><div class="GetWidthMatrix"><a href="javascript:;">调整列宽</a></div></div></li></ul></div></div><script type="text/javascript">$("li[oid=\'${qmodel.qid}\'] .GetWidthMatrix").click(function(){var oid = $(this).parents(".module").attr("oid");mapsets(960,520,"矩阵题列宽调整","/edit/question_preview/"+oid+"/");});</script></li>';
var source_qmatrix_multiple = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled"><li><div class="matrix" style="min-height: 60px;"><table class="table table-bordered td-Tc" cellspacing="0" cellpadding="0"><tbody><tr><td>&nbsp;</td>{@each question.option_list as option}<td class="T_edit_td" name="option" id="${option._id.$oid}" menutype="col" {@if option.is_open}is_open="1"{@/if}>$${option.title}</td>{@/each}</tr>{@each question.matrixrow_list as row}<tr class="Ed_tr"><td class="T_edit_td" id="${row._id.$oid}" name="row" style="text-align:left;" menutype="row">$${row.title}</td>{@each question.option_list as option}<td><input type="checkbox" name="">{@if option.is_open}<input type="text" name="" id="" class="open_input">{@/if}</td>{@/each}</tr>{@/each}</tbody></table></div><div class="operationV"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></li><li><div class="operationH"><a href="javascript:;" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a><div class="GetWidthMatrix"><a href="javascript:;">调整列宽</a></div></div></li></ul></div></div><script type="text/javascript">$("li[oid=\'${qmodel.qid}\'] .GetWidthMatrix").click(function(){var oid = $(this).parents(".module").attr("oid");mapsets(960,520,"矩阵题列宽调整","/edit/question_preview/"+oid+"/");});</script></li>';
var source_qmatrix_blank = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled"><li><div class="matrix" style="min-height: 60px;"><table class="table table-bordered td-Tc" cellspacing="0" cellpadding="0"><tbody><tr><td>&nbsp;</td>{@each question.option_list as option}<td class="T_edit_td" name="option" id="${option._id.$oid}" menutype="col">$${option.title}</td>{@/each}</tr>{@each question.matrixrow_list as row}<tr class="Ed_tr"><td class="T_edit_td" id="${row._id.$oid}" name="row" style="text-align:left;" menutype="row">$${row.title}</td>{@each question.option_list as option}<td><textarea rows="${option.custom_attr.text_row}" cols="${parseInt(option.custom_attr.text_col) * 2}"></textarea></td>{@/each}</tr>{@/each}</tbody></table></div><div class="operationV"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></li><li><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a><div class="GetWidthMatrix"><a href="javascript:;">调整列宽</a></div></div></li></ul></div></div><script type="text/javascript">$("li[oid=\'${qmodel.qid}\'] .GetWidthMatrix").click(function(){var oid = $(this).parents(".module").attr("oid");mapsets(960,520,"矩阵题列宽调整","/edit/question_preview/"+oid+"/");});</script></li>';
var source_qmatrix_score = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}" minnum="${question.custom_attr.min_answer_num}" maxnum="${question.custom_attr.max_answer_num}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div><ul class="unstyled"><li><div class="matrix" style="min-height: 60px;"><table class="table table-bordered  td-Tc" cellspacing="0" cellpadding="0"><tbody><tr><td>&nbsp;</td>{@each question.option_list as option}<td class="T_edit_td" name="option" menutype="col" id="${option._id.$oid}">$${option.title}</td>{@/each}</tr>{@each question.matrixrow_list as row}<tr class="Ed_tr"><td class="T_edit_td" name="row" id="${row._id.$oid}" style="text-align:left;" menutype="row">$${row.title}</td>{@each question.option_list as option}<td><div class="dfW">{@each i in range(1, parseInt(question.custom_attr.max_answer_num) + 1)}<a href="javascript:;"><i class="basic-too14-icon-active"></i></a>{@/each}</div></td>{@/each}</tr>{@/each}</tbody></table></div><div class="operationV"><a href="javascript:;" class="cq_add" style="display: none;"><i class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a></div></li><li><div class="operationH"><a href="javascript:;" class="cq_add" style="display: none;"><i  class="add-icon-active"></i></a><a href="javascript:;" class="Bub" style="display: none;"><i class="clone-icon-active"></i></a><div class="GetWidthMatrix"><a href="javascript:;">调整列宽</a></div></div></li></ul></div></div><script type="text/javascript">$("li[oid=\'${qmodel.qid}\'] .GetWidthMatrix").click(function(){var oid = $(this).parents(".module").attr("oid");mapsets(960,520,"矩阵题列宽调整","/edit/question_preview/"+oid+"/");});var stars_count = ${question.custom_attr.max_answer_num};$("li[oid=\'"+"${qmodel.qid}"+"\']").find(".dfW").width(stars_count*29);</script></li>';
var source_qdesc = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a class="Bub" href="javascript:;" style="display: none;"><i class="copy-icon-active"></i></a><a class="Del" href="javascript:;" style="display: none;"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div class="th4 T_edit q_title" name="question">$${question.title}</div></div></div></div></li>';
var source_qdesc_split_line = '<li class="module split_line" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu" style="padding-top:10px;"><div class="setup-group"><a style="display: none;" href="javascript:;" class="Del cq_fgx"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area dline"><div class="DividingLine"></div></div></div></div></li>';
var source_qblank_date = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title">$${question.title}</div></div><ul class="unstyled"><li><div id="${qmodel.qid}" class="question_date_edit"><input class="BlankDate"  type="text" id="date_${qmodel.qid}"/></div></li></ul></div></div></li><script type="text/javascript">$("#date_${qmodel.qid}").Zebra_DatePicker({show_week_number: "周"});</script>';
var source_qblank_time = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title">$${question.title}</div></div><ul class="unstyled"><li><div class="Time_con"><select class="Time_Hour"><option value="-1">小时</option>undefined<option value="0">0</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option></select><span> : </span><select class="Time_Minute"><option value="-1">分钟</option><option value="0">0</option><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option><option value="15">15</option><option value="16">16</option><option value="17">17</option><option value="18">18</option><option value="19">19</option><option value="20">20</option><option value="21">21</option><option value="22">22</option><option value="23">23</option><option value="24">24</option><option value="25">25</option><option value="26">26</option><option value="27">27</option><option value="28">28</option><option value="29">29</option><option value="30">30</option><option value="31">31</option><option value="32">32</option><option value="33">33</option><option value="34">34</option><option value="35">35</option><option value="36">36</option><option value="37">37</option><option value="38">38</option><option value="39">39</option><option value="40">40</option><option value="41">41</option><option value="42">42</option><option value="43">43</option><option value="44">44</option><option value="45">45</option><option value="46">46</option><option value="47">47</option><option value="48">48</option><option value="49">49</option><option value="50">50</option><option value="51">51</option><option value="52">52</option><option value="53">53</option><option value="54">54</option><option value="55">55</option><option value="56">56</option><option value="57">57</option><option value="58">58</option><option value="59">59</option></select></div></li></ul></div></div></li>';
var source_qimage_single = '<li oid="${qmodel.qid}" class="module question" issue="88"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title">$${question.title}</div></div><ul class="unstyled Imgli">{@each question.option_list as option}<li><div class="questionImgBox" name="${option._id.$oid}"><div style="" class="QImgCon"><img src="$${option.custom_attr.images.thumbnail_src}" Maxsrc="$${option.custom_attr.images.src}" bbox="${option.custom_attr.images.bbox}" orig_width="${option.custom_attr.images.orig_width}"></div><input type="radio" name="radio" id="option_${option._id.$oid}" value="option_${option._id.$oid}"><label class="T_edit_min" for="" name="option" id="${option._id.$oid}">$${option.title}</label></div></li>{@/each}<li class="dragZone"><div class="questionImgBox abor"><div class="AddQImgCon"><div class="uploader"><label><input type="file" name="files[]" multiple="multiple" title="添加图片"></label></div></div><div class="AddQImgCon_ie"><div class="file-box"><form enctype="multipart/form-data" method="POST" action="" id="logo_uploader_form"><iframe style="filter:alpha(opacity = 0);-moz-opacity:0;-khtml-opacity:0;opacity:0;position:absolute;top:0;left:0;width:100%;height:100%;" id="imgUpload" class="uploadfile" src="/edit/form/ajax/create_image_option/${question.project_id}/?qid=${qmodel.qid}&plugin=1"></iframe><div class="WJButton wj_blue smallerfontsize">上传</div></form></div></div></li></ul></div></div></li><script type="text/javascript">new QuestionImg("${qmodel.qid}");$("li[oid=${qmodel.qid}] .QImgCon").click(function() {var _this = $(this).find("img");var url = _this.attr("Maxsrc");var option_id = _this.parents(".questionImgBox").attr("name");var bbox = _this.attr("bbox");var orig_width = _this.attr("orig_width");if(bbox==undefined||bbox==""){bbox="[75,75,150,150]";}bbox = bbox.parseJSON();new CreateJcrop(url, ChgThumbnailCallback, option_id,bbox,orig_width);});</script>';
var source_qimage_multiple = '<li oid="${qmodel.qid}" class="module question" issue="88"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title">$${question.title}</div></div><ul class="unstyled Imgli">{@each question.option_list as option}<li><div class="questionImgBox" id="${option._id.$oid}"><div style="" class="QImgCon"><img src="$${option.custom_attr.images.thumbnail_src}" Maxsrc="$${option.custom_attr.images.src}" bbox="${option.custom_attr.images.bbox}" orig_width="${option.custom_attr.images.orig_width}"></div><input type="checkbox" name="checkbox" id="option_${option._id.$oid}" value="option_${option._id.$oid}"><label class="T_edit_min" for="" name="option" id="${option._id.$oid}">$${option.title}</label></div></li>{@/each}<li class="dragZone"><div class="questionImgBox abor"><div class="AddQImgCon"><div class="uploader"><label><input type="file" name="files[]" multiple="multiple" title="添加图片"></label></div></div><div class="AddQImgCon_ie"><div class="file-box"><form enctype="multipart/form-data" method="POST" action="" id="logo_uploader_form"><iframe style="filter:alpha(opacity = 0);-moz-opacity:0;-khtml-opacity:0;opacity:0;position:absolute;top:0;left:0;width:100%;height:100%;" id="imgUpload" class="uploadfile" src="/edit/form/ajax/create_image_option/${question.project_id}/?qid=${qmodel.qid}&plugin=1"></iframe><div class="WJButton wj_blue smallerfontsize">上传</div></form></div></div></li></ul></div></div></li><script type="text/javascript">new QuestionImg("${qmodel.qid}");$("li[oid=${qmodel.qid}] .QImgCon").click(function() {var _this = $(this).find("img");var url = _this.attr("Maxsrc");var option_id = _this.parents(".questionImgBox").attr("id");var bbox = _this.attr("bbox");var orig_width = _this.attr("orig_width");if(bbox==undefined||bbox==""){bbox="[75,75,150,150]";}bbox = bbox.parseJSON();new CreateJcrop(url, ChgThumbnailCallback, option_id,bbox,orig_width);});</script>';
var source_qblank_upload_file = '<li class="module question" oid="${qmodel.qid}" issue="${question.question_type}"><div class="topic_type"><div class="topic_type_menu"><div class="setup-group"><h4></h4><a class="up_cq" href="javascript:;"><i class="up-icon-active" ></i></a><a class="down_cq" href="javascript:;"><i class="down-icon-active" ></i></a><a style="display: none;" href="javascript:;" class="Bub"><i class="copy-icon-active"></i></a><a style="display: none;" href="javascript:;" class="Del"><i class="del2-icon-active"></i></a></div></div><div class="topic_type_con"><div class="Drag_area"><div name="question" class="th4 T_edit q_title"><p><span style="COLOR: #666666"><span style="FONT-SIZE: 16px"><span>$${qmodel.title}</span></span></span></p></div></div><div class="upFile"><div class="upBut"><div class="Hbuttom">选择文件</div></div><p><span>( 5MB以内 )</span></p><p style="color: #B1B1B1;margin-top: 45px;text-align: right;">*部分较老的手机可能不支持上传功能</p></div></div></div></li>';

var TemplateFactory = {
    getHtml: function(qmodel, source){
        var disp_type = qmodel.question.custom_attr['disp_type'] || 'vertical';
        var column_count = qmodel.question.custom_attr['column_count'] || '1';
        var col_width = 100/parseInt(column_count) + '%';
        if (disp_type == 'vertical'){
            col_width = '100%';
        }
        var data = {"qmodel": qmodel, "question": qmodel.question, 'disp_type': disp_type, 'column_count': column_count, 'col_width': col_width};
        return juicer(source, data);
    }
};