package com.java.service.terminal;
 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.TerminalMapper;
import com.java.model.TerminalResult;
import com.java.po.Terminal;
@Service
public class TerminalServiceImpl implements TerminalService {
    @Autowired
    private TerminalMapper terminalMapper;
    @Override
    public int insert(Terminal terminal) {
        int i = 0;
        Date date = new Date();
        terminal.setUsedate(date);
        terminal.setLastupdate(date);
        try {
            i = terminalMapper.insert(terminal);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return i;
    }
 
    @Override
    public int delete(int id) {
        int i = 0;
        try {
            i = terminalMapper.delete(id);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return i;
    }
 
    @Override
    public int updata(Terminal terminal) {
        Date date = new Date();
        terminal.setLastupdate(date);
        int i = 0;
        try {
            i = terminalMapper.update(terminal);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }
 
    @Override
    public Terminal queryTerminalId(int id) {
        return terminalMapper.queryTerminalId(id);
    }
    
    @Override
    public int queryNum(String num) {
        
        return terminalMapper.queryNum(num);
    }
    
    @Override
    public Map<String,Object> queryTerminal(int draw, int start, int length,Terminal terminal, String customernum) {
    	Integer terminalid = terminal.getTerminalid();
    	String mtype = terminal.getMtype();
        String isuse = terminal.getIsuse();
        String owner = terminal.getOwner();
        String devicenum = terminal.getDevicenum();
        Date usedate = terminal.getUsedate();
        // 使用PageHelper分页
        PageHelper.startPage(start, length);
        List<TerminalResult> list = terminalMapper.queryTerminal(mtype, isuse, owner, devicenum, usedate, terminalid, customernum);
        PageInfo<TerminalResult> pageinfo = new PageInfo<>(list);
        // 将得到的pageinfo类进行转化给datatable方便前台展示
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("draw",draw);
        resultMap.put("recordsTotal",pageinfo.getTotal());
        resultMap.put("recordsFiltered",pageinfo.getTotal());
        resultMap.put("data",list);
        return resultMap;
    }
    //-------------
    //给simcard提供list接口
    /**
     * 获取终端Id展示在添加sim卡信息的下拉列表中
     */
    @Override
    public List<Integer> getTeminalIdList() {
        
        List<Integer> teminalIdList = terminalMapper.getTeminalIdList();
        return teminalIdList;
    }
    /**
     * 下拉框终端Id值改变时，设备编码自动填充
     */
    @Override
    public String getTeminalNum(Integer id) {
        String teminalIdNum = terminalMapper.getTeminalNum(id);
        return teminalIdNum;
    }
 
 
    
}
