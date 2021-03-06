/*
 * $Id: MainPanel.js,v 1.54 2009/04/13 11:23:24 gaudenz Exp $
 * Copyright (c) 2008, Gaudenz Alder
 */
MainPanel = function(graph, history)
{
	var executeLayout = function(layout, animate, ignoreChildCount)
	{
		var cell = graph.getSelectionCell();
		
		if (cell == null ||
			(!ignoreChildCount &&
			graph.getModel().getChildCount(cell) == 0))
		{
			cell = graph.getDefaultParent();
		}

		// Animates the changes in the graph model except
		// for Camino, where animation is too slow
		if (animate && navigator.userAgent.indexOf('Camino') < 0)
		{
			var listener = function(sender, evt)
			{
				mxUtils.animateChanges(graph, evt.getArgAt(0)/*changes*/);
				graph.getModel().removeListener(listener);
			};
			
			graph.getModel().addListener(mxEvent.CHANGE, listener);
		}

        layout.execute(cell);
	};
	
	// Defines various color menus for different colors
    var fillColorMenu = new Ext.menu.ColorMenu(
    {
    	items: [
    	{
    		text: 'None',
    		handler: function()
    		{
    			graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, mxConstants.NONE);
    		}
    	},
    	'-'
    	],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
				graph.setCellStyles(mxConstants.STYLE_FILLCOLOR, '#'+color);
			}
        }
    });

    var gradientColorMenu = new Ext.menu.ColorMenu(
    {
		items: [
        {
            text: 'North',
            handler: function()
            {
                graph.setCellStyles(mxConstants.STYLE_GRADIENT_DIRECTION, mxConstants.DIRECTION_NORTH);
            }
        },
        {
            text: 'East',
            handler: function()
            {
                graph.setCellStyles(mxConstants.STYLE_GRADIENT_DIRECTION, mxConstants.DIRECTION_EAST);
            }
        },
        {
            text: 'South',
            handler: function()
            {
                graph.setCellStyles(mxConstants.STYLE_GRADIENT_DIRECTION, mxConstants.DIRECTION_SOUTH);
            }
        },
        {
            text: 'West',
            handler: function()
            {
                graph.setCellStyles(mxConstants.STYLE_GRADIENT_DIRECTION, mxConstants.DIRECTION_WEST);
            }
        },
        '-',
		{
			text: 'None',
			handler: function()
			{
        		graph.setCellStyles(mxConstants.STYLE_GRADIENTCOLOR, mxConstants.NONE);
        	}
		},
		'-'
		],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
    			graph.setCellStyles(mxConstants.STYLE_GRADIENTCOLOR, '#'+color);
			}
        }
    });

    var fontColorMenu = new Ext.menu.ColorMenu(
    {
    	items: [
    	{
    		text: 'None',
    		handler: function()
    		{
    			graph.setCellStyles(mxConstants.STYLE_FONTCOLOR, mxConstants.NONE);
    		}
    	},
    	'-'
    	],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
    			graph.setCellStyles(mxConstants.STYLE_FONTCOLOR, '#'+color);
			}
        }
    });

    var lineColorMenu = new Ext.menu.ColorMenu(
    {
    	items: [
		{
			text: 'None',
			handler: function()
			{
				graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, mxConstants.NONE);
			}
		},
		'-'
		],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
				graph.setCellStyles(mxConstants.STYLE_STROKECOLOR, '#'+color);
			}
        }
    });

    var labelBackgroundMenu = new Ext.menu.ColorMenu(
    {
		items: [
		{
			text: 'None',
			handler: function()
			{
				graph.setCellStyles(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, mxConstants.NONE);
			}
		},
		'-'
		],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
    			graph.setCellStyles(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, '#'+color);
    		}
        }
    });

    var labelBorderMenu = new Ext.menu.ColorMenu(
    {
		items: [
		{
			text: 'None',
			handler: function()
			{
				graph.setCellStyles(mxConstants.STYLE_LABEL_BORDERCOLOR, mxConstants.NONE);
			}
		},
		'-'
		],
        handler : function(cm, color)
        {
    		if (typeof(color) == "string")
    		{
    			graph.setCellStyles(mxConstants.STYLE_LABEL_BORDERCOLOR, '#'+color);
			}
        }
    });
    
    // Defines the font family menu
    var fonts = new Ext.data.SimpleStore(
    {
        fields: ['label', 'font'],
        data : [['Helvetica', 'Helvetica'], ['Verdana', 'Verdana'],
        	['Times New Roman', 'Times New Roman'], ['Garamond', 'Garamond'],
        	['Courier New', 'Courier New']]
    });
    
    var fontCombo = new Ext.form.ComboBox(
    {
        store: fonts,
        displayField:'label',
        mode: 'local',
        width:120,
        triggerAction: 'all',
        emptyText:'Select a font...',
        selectOnFocus:true,
        onSelect: function(entry)
        {
        	if (entry != null)
        	{
				graph.setCellStyles(mxConstants.STYLE_FONTFAMILY, entry.data.font);
				this.collapse();
        	}
        }
    });
    
	// Handles typing a font name and pressing enter
    fontCombo.on('specialkey', function(field, evt)
    {
    	if (evt.keyCode == 10 ||
    		evt.keyCode == 13)
    	{
    		var family = field.getValue();
    		
    		if (family != null &&
    			family.length > 0)
    		{
    			graph.setCellStyles(mxConstants.STYLE_FONTFAMILY, family);
    		}
    	}
    });

    // Defines the font size menu
    var sizes = new Ext.data.SimpleStore({
        fields: ['label', 'size'],
        data : [['6pt', 6], ['8pt', 8], ['9pt', 9], ['10pt', 10], ['12pt', 12],
        	['14pt', 14], ['18pt', 18], ['24pt', 24], ['30pt', 30], ['36pt', 36],
        	['48pt', 48],['60pt', 60]]
    });
    
    var sizeCombo = new Ext.form.ComboBox(
    {
        store: sizes,
        displayField:'label',
        mode: 'local',
        width:50,
        triggerAction: 'all',
        emptyText:'12pt',
        selectOnFocus:true,
        onSelect: function(entry)
        {
        	if (entry != null)
        	{
				graph.setCellStyles(mxConstants.STYLE_FONTSIZE, entry.data.size);
				this.collapse();
        	}
        }
    });
    
	// Handles typing a font size and pressing enter
    sizeCombo.on('specialkey', function(field, evt)
    {
    	if (evt.keyCode == 10 ||
    		evt.keyCode == 13)
    	{
    		var size = parseInt(field.getValue());
    		
    		if (!isNaN(size) &&
    			size > 0)
    		{
    			graph.setCellStyles(mxConstants.STYLE_FONTSIZE, size);
    		}
    	}
    });

	this.graphPanel = new Ext.Panel(
    {
    	region: 'center',
    	border:false,
        tbar:[
        {
            text:'',
            iconCls: 'new-icon',
            tooltip: 'New Diagram',
            handler: function()
            {
            	var cell = new mxCell();
            	cell.insert(new mxCell());
            	
            	graph.getModel().setRoot(cell);
            },
            scope:this
        },
        '-',
        {
        	id: 'print',
            text:'',
            iconCls: 'print-icon',
            tooltip: 'Printer-friendly version',
            handler: function()
            {
        		var preview = new mxPrintPreview(graph, 1, null,
        				0, 0, null, 'Printer-friendly version');
        		preview.open();
            },
            scope:this
        },
        {
        	id: 'view',
            text:'',
            iconCls: 'preview-icon',
            tooltip: 'Show',
            handler: function()
            {
        		mxUtils.show(graph);
            },
            scope:this
        },
        '-',
        {
        	id: 'cut',
            text:'',
            iconCls: 'cut-icon',
            tooltip: 'Cut',
            handler: function()
            {
        		mxClipboard.cut(graph);
        	},
            scope:this
        },{
       		id: 'copy',
            text:'',
            iconCls: 'copy-icon',
            tooltip: 'Copy',
            handler: function()
            {
        		mxClipboard.copy(graph);
        	},
            scope:this
        },{
            text:'',
            iconCls: 'paste-icon',
            tooltip: 'Paste',
            handler: function()
            {
            	mxClipboard.paste(graph);
            },
            scope:this
        },
        '-',
        {
       		id: 'delete',
            text:'',
            iconCls: 'delete-icon',
            tooltip: 'Delete',
            handler: function()
            {
        		graph.removeCells();
        	},
            scope:this
        },
        '-',
        {
        	id: 'undo',
            text:'',
            iconCls: 'undo-icon',
            tooltip: 'Undo',
            handler: function()
            {
            	history.undo();
            },
            scope:this
        },{
        	id: 'redo',
            text:'',
            iconCls: 'redo-icon',
            tooltip: 'Redo',
            handler: function()
            {
        		history.redo();
            },
            scope:this
        },
        '-',
        fontCombo,
        ' ',
        sizeCombo,
        '-',
		{
			id: 'bold',
            text: '',
            iconCls:'bold-icon',
            tooltip: 'Bold',
            handler: function()
            {
        		graph.toggleCellStyleFlags(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_BOLD);
        	},
            scope:this
        },
		{
			id: 'italic',
            text: '',
            tooltip: 'Italic',
            iconCls:'italic-icon',
            handler: function()
            {
            	graph.toggleCellStyleFlags(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_ITALIC);
            },
            scope:this
        },
		{
			id: 'underline',
            text: '',
            tooltip: 'Underline',
            iconCls:'underline-icon',
            handler: function()
            {
        		graph.toggleCellStyleFlags(mxConstants.STYLE_FONTSTYLE, mxConstants.FONT_UNDERLINE);
        	},
            scope:this
        },
        '-',
        {
            id: 'align',
            text:'',
            iconCls: 'left-icon',
            tooltip: 'Text Alignment',
            handler: function() { },
            menu:
            {
                id:'reading-menu',
                cls:'reading-menu',
                items: [
                {
                    text:'Left',
                    checked:false,
                    group:'rp-group',
                    scope:this,
                    iconCls:'left-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
                	}
                },
                {
                    text:'Center',
                    checked:true,
                    group:'rp-group',
                    scope:this,
                    iconCls:'center-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
                	}
                },
                {
                    text:'Right',
                    checked:false,
                    group:'rp-group',
                    scope:this,
                    iconCls:'right-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT);
                	}
                },
                '-',
                {
                    text:'Top',
                    checked:false,
                    group:'vrp-group',
                    scope:this,
                    iconCls:'top-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_TOP);
                	}
                },
                {
                    text:'Middle',
                    checked:true,
                    group:'vrp-group',
                    scope:this,
                    iconCls:'middle-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
                	}
                },
                {
                    text:'Bottom',
                    checked:false,
                    group:'vrp-group',
                    scope:this,
                    iconCls:'bottom-icon',
                    handler: function()
                    {
                		graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_BOTTOM);
                    }
                }]
            }
        },
        '-',
		{
			id: 'fontcolor',
            text: '',
            tooltip: 'Fontcolor',
            iconCls:'fontcolor-icon',
            menu: fontColorMenu // <-- submenu by reference
        },
		{
			id: 'linecolor',
            text: '',
            tooltip: 'Linecolor',
            iconCls:'linecolor-icon',
            menu: lineColorMenu // <-- submenu by reference
        },
		{
			id: 'fillcolor',
            text: '',
            tooltip: 'Fillcolor',
            iconCls:'fillcolor-icon',
            menu: fillColorMenu // <-- submenu by reference
        }],
        bbar:[
        {
            text:'Zoom',
            iconCls: 'zoom-icon',
            handler: function(menu) { },
            menu:
            {
                items: [
                {
		            text:'Custom',
		            scope:this,
		            handler: function(item)
		            {
		            	var value = mxUtils.prompt('Enter Source Spacing (Pixels)', parseInt(graph.getView().getScale() * 100));
										            	
		            	if (value != null)
		            	{
			            	graph.getView().setScale(parseInt(value) / 100);
			            }
		            }
		        },
		        '-',
                {
		            text:'400%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(4);
		            }
		        },
                {
		            text:'200%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(2);
		            }
		        },
                {
		            text:'150%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(1.5);
		            }
		        },
		        {
		            text:'100%',
		            scope:this,
		            handler: function(item)
		            {
		                graph.getView().setScale(1);
		            }
		        },
                {
		            text:'75%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(0.75);
		            }
		        },
                {
		            text:'50%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(0.5);
		            }
		        },
                {
		            text:'25%',
		            scope:this,
		            handler: function(item)
		            {
						graph.getView().setScale(0.25);
		            }
		        },
                '-',
                {
		            text:'Zoom In',
		            iconCls: 'zoomin-icon',
		            scope:this,
		            handler: function(item)
		            {
						graph.zoomIn();
		            }
		        },
		        {
		            text:'Zoom Out',
		            iconCls: 'zoomout-icon',
		            scope:this,
		            handler: function(item)
		            {
		                graph.zoomOut();
		            }
		        },
		        '-',
		        {
		            text:'Actual Size',
		            iconCls: 'zoomactual-icon',
		            scope:this,
		            handler: function(item)
		            {
		                graph.zoomActual();
		            }
		        },
		        {
		            text:'Fit Window',
		            iconCls: 'fit-icon',
		            scope:this,
		            handler: function(item)
		            {
		                graph.fit();
		            }
		        }]
            }
        },
        '-',
        {
            text:'Layout',
            iconCls: 'diagram-icon',
            handler: function(menu) { },
            menu:
            {
                items: [
		        {
		            text:'Vertical Hierarchical Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxHierarchicalLayout(graph), true);
		            }
		        },
		        {
		            text:'Horizontal Hierarchical Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxHierarchicalLayout(graph,
		        				mxConstants.DIRECTION_WEST), true);
		            }
		        },
		        '-',
		        {
		            text:'Vertical Partition Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxPartitionLayout(graph, false));
		            }
		        },
		        {
		            text:'Horizontal Partition Layout',
		            scope:this,
		            handler: function(item)
		            {
	        			executeLayout(new mxPartitionLayout(graph));
		            }
		        },
		        '-',
		        {
		            text:'Vertical Stack Layout',
		            scope:this,
		            handler: function(item)
		            {
		                var layout = new mxStackLayout(graph, false);
		                layout.fill = true;
		                executeLayout(layout);
		            }
		        },
		        {
		            text:'Horizontal Stack Layout',
		            scope:this,
		            handler: function(item)
		            {
		                var layout = new mxStackLayout(graph, false);
		                layout.fill = true;
		                executeLayout(layout);
		            }
		        },
		        '-',
                {
		            text:'Vertical Tree Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxCompactTreeLayout(graph, false), true, true);
		            }
		        },
		        {
		            text:'Horizontal Tree Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxCompactTreeLayout(graph), true, true);
		            }
		        },
		        '-',
		        {
		            text:'Place Edge Labels',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxEdgeLabelLayout(graph));
		            }
		        },
		        {
		            text:'Parallel Edges',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxParallelEdgeLayout(graph));
		            }
		        },
		        '-',
		        {
		            text:'Circle Layout',
		            scope:this,
		            handler: function(item)
		            {
		        		executeLayout(new mxCircleLayout(graph), true);
		            }
		        },
		        {
		            text:'Organic Layout',
		            scope:this,
		            handler: function(item)
		            {
		                var layout = new mxFastOrganicLayout(graph);
		                layout.forceConstant = 80;
		        	
		        		executeLayout(layout, true);
		            }
		        }]
            }
        },
        '-',
        {
            text:'Options',
            iconCls: 'preferences-icon',
            handler: function(menu) { },
            menu:
            {
                items: [
                {
                    text:'Grid',
                    handler: function(menu) { },
                    menu:
                    {
                    	items: [
        		        {
        		            text:'Grid Size',
        		            scope:this,
        		            handler: function()
        		            {
        						var value = mxUtils.prompt('Enter Grid Size (Pixels)', graph.gridSize);
        										            	
        		            	if (value != null)
        		            	{
        			            	graph.gridSize = value;
        			            }
        		            }
        		        },
        		        {
        		            checked: true,
        		            text:'Grid Enabled',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setGridEnabled(checked);
        		            }
        		        }
        		        ]
                    }
                },
                {
	                text:'Stylesheet',
	                handler: function(menu) { },
	                menu:
	                {
	                	items: [
	                	{
				            text:'Basic Style',
				            scope:this,
				            handler: function(item)
				            {
							    var node = mxUtils.load('resources/basic-style.xml').getDocumentElement();
								var dec = new mxCodec(node.ownerDocument);
								dec.decode(node, graph.getStylesheet());    
								graph.refresh();
				            }
				        },
				        {
				            text:'Default Style',
				            scope:this,
				            handler: function(item)
				            {
							    var node = mxUtils.load('resources/default-style.xml').getDocumentElement();
								var dec = new mxCodec(node.ownerDocument);
								dec.decode(node, graph.getStylesheet());    
								graph.refresh();
				            }
				        }]
	                }
                },
                {
                    text:'Labels',
                    handler: function(menu) { },
                    menu:
                    {
                    	items: [
        		        {
        		            checked: true,
        		            text:'Show Labels',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		            	graph.labelsVisible = checked;
        		            	graph.refresh();
        		            }
        		        },
        		        {
        		            checked: true,
        		            text:'Move Edge Labels',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		            	graph.edgeLabelsMovable = checked;
        		            }
        		        },
        		        {
        		            checked: false,
        		            text:'Move Vertex Labels',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		           		graph.vertexLabelsMovable = checked;
        		            }
        		        }
            	        ]
                    }
                },
                '-',
                {
                    text:'Connections',
                    handler: function(menu) { },
                    menu:
                    {
                    	items: [
                        {
        		            checked: true,
        		            text:'Connectable',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setConnectable(checked);
        		            }
        		        },
        		        {
        		            checked: false,
        		            text:'Connectable Edges',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setConnectableEdges(checked);
        		            }
        		        },
        		        '-',
                        {
        		            checked: true,
        		            text:'Create Target',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.connectionHandler.setCreateTarget(checked);
        		            }
        		        }
            	        ]
                    }
                },
                {
                    text:'Validation',
                    handler: function(menu) { },
                    menu:
                    {
                    	items: [
        		        {
        		            checked: true,
        		            text:'Allow Dangling Edges',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setAllowDanglingEdges(checked);
        		            }
        		        },
        		        {
        		            checked: false,
        		            text:'Clone Invalid Edges',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setCloneInvalidEdges(checked);
        		            }
        		        },
        		        '-',
        		        {
        		            checked: false,
        		            text:'Allow Loops',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setAllowLoops(checked);
        		            }
        		        },
        		        {
        		            checked: true,
        		            text:'Multigraph',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setMultigraph(checked);
        		            }
        		        },
        		        '-',
        		        {
        		            checked: true,
        		            text:'Disconnect On Move',
        		            scope:this,
        		            checkHandler: function(item, checked)
        		            {
        		                graph.setDisconnectOnMove(checked);
        		            }
        		        }
            	        ]
                    }
                },
                '-',
		        {
		            text:'Show XML',
		            scope:this,
		            handler: function(item)
		            {
						var enc = new mxCodec(mxUtils.createXmlDocument());
						var node = enc.encode(graph.getModel());
						mxUtils.popup(mxUtils.getPrettyXml(node));
		            }
		        },
		        {
		            text:'Parse XML',
		            scope:this,
		            handler: function(item)
		            {
		        		var xml = mxUtils.prompt('Enter XML:', '');
		        		
		        		if (xml != null && xml.length > 0)
		        		{
		        			var doc = mxUtils.parseXml(xml); 
		        			var dec = new mxCodec(doc); 
		        			dec.decode(doc.documentElement, graph.getModel()); 
		        		}
		            }
		        },
		        '-',
		        {
		            text:'Console',
		            scope:this,
		            handler: function(item)
		            {
		            	mxLog.setVisible(!mxLog.isVisible());
		            }
		        }]
            }
        }],

        onContextMenu : function(node, e)
        {
    		var selected = !graph.isSelectionEmpty();

    		this.menu = new Ext.menu.Menu(
    		{
                id:'feeds-ctx',
                items: [{
                    text:'Undo',
                    iconCls:'undo-icon',
                    disabled: !history.canUndo(),
                    scope: this,
                    handler:function()
                    {
                        history.undo();
                    }
                },'-',{
                    text:'Cut',
                    iconCls:'cut-icon',
                    disabled: !selected,
                    scope: this,
                    handler:function()
                    {
                    	mxClipboard.cut(graph);
                    }
                },{
                    text:'Copy',
                    iconCls:'copy-icon',
                    disabled: !selected,
                    scope: this,
                    handler:function()
                    {
                    	mxClipboard.copy(graph);
                    }
                },{
                    text:'Paste',
                    iconCls:'paste-icon',
                    disabled: mxClipboard.isEmpty(),
                    scope: this,
                    handler:function()
                    {
                    	mxClipboard.paste(graph);
                    }
                },
                '-',
                {
                    text:'Delete',
                    iconCls:'delete-icon',
                    disabled: !selected,
                    scope: this,
                    handler:function()
                    {
                    	graph.removeCells();
                    }
                },
              	'-',
              	{
		            text:'Format',
		            disabled: !selected,
		            handler: function() { },
		            menu:
		            {
		            	items: [
		            	{
		            		text:'Background',
				            disabled: !selected,
				            handler: function() { },
				            menu:
				            {
				            	items: [
				                {
						            text: 'Fillcolor',
						            iconCls:'fillcolor-icon',
						            menu: fillColorMenu
						        },
				                {
						            text: 'Gradient',
						            menu: gradientColorMenu
						        },
						        '-',
						        {
						            text: 'Image',
						            handler: function()
						            {
						            	var value = '';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_IMAGE] || value;
						            	}

					            		value = mxUtils.prompt('Enter Image URL', value);
						            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_IMAGE, value);
							            }
						            }
						        },
						        {
						            text:'Shadow',
						            scope:this,
						            handler: function()
						            {
						                graph.toggleCellStyles(mxConstants.STYLE_SHADOW);
						            }
						        },
						        '-',
						        {
						            text:'Opacity',
						            scope:this,
						            handler: function()
						            {
						            	var value = mxUtils.prompt('Enter Opacity (0-100%)', '100');
						            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_OPACITY, value);
							            }
						            }
						        }]
				            }
		            	},
			            {
		            		text:'Label',
				            disabled: !selected,
				            handler: function() { },
				            menu:
				            {
				            	items: [
								{
						            text: 'Fontcolor',
						            iconCls:'fontcolor-icon',
						            menu: fontColorMenu
						        },
						        '-',
				                {
						            text: 'Label Fill',
						            menu: labelBackgroundMenu
						        },
				                {
						            text: 'Label Border',
						            menu: labelBorderMenu
						        },
						        '-',
								{
						            text:'Rotate Label',
						            scope:this,
						            handler: function()
						            {
						                graph.toggleCellStyles(mxConstants.STYLE_HORIZONTAL, true);
						            }
						        },
						        {
						            text:'Text opacity',
						            scope:this,
						            handler: function()
						            {
						            	var value = mxUtils.prompt('Enter text opacity (0-100%)', '100');
						            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_TEXT_OPACITY, value);
							            }
						            }
						        },
						        '-',
					            {
				            		text:'Position',
						            disabled: !selected,
						            handler: function() { },
						            menu:
						            {
						            	items: [
					            		{
								            text: 'Top',
								            scope:this,
								            handler: function()
								            {
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_TOP);
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_BOTTOM);
								            }
								        },
					            		{
								            text: 'Middle',
								            scope:this,
								            handler: function()
								            {
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_MIDDLE);
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_MIDDLE);
								            }
								        },
					            		{
								            text: 'Bottom',
								            scope:this,
								            handler: function()
								            {
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_BOTTOM);
					            				graph.setCellStyles(mxConstants.STYLE_VERTICAL_ALIGN, mxConstants.ALIGN_TOP);
								            }
								        },
								        '-',
					            		{
								            text: 'Left',
								            scope:this,
								            handler: function()
								            {
					            				graph.setCellStyles(mxConstants.STYLE_LABEL_POSITION, mxConstants.ALIGN_LEFT);
					            				graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_RIGHT);
								            }
								        },
					            		{
								            text: 'Center',
								            scope:this,
								            handler: function()
								            {
				            				graph.setCellStyles(mxConstants.STYLE_LABEL_POSITION, mxConstants.ALIGN_CENTER);
				            				graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_CENTER);
								            }
								        },
					            		{
								            text: 'Right',
								            scope:this,
								            handler: function()
								            {
				            				graph.setCellStyles(mxConstants.STYLE_LABEL_POSITION, mxConstants.ALIGN_RIGHT);
				            				graph.setCellStyles(mxConstants.STYLE_ALIGN, mxConstants.ALIGN_LEFT);
								            }
								        }]
						            }
					            },
						        '-',
								{
						            text:'Hide',
						            scope:this,
						            handler: function()
						            {
						                graph.toggleCellStyles(mxConstants.STYLE_NOLABEL, false);
						            }
						        }]
				            }
			            },
			            '-',
			            {
		            		text:'Line',
				            disabled: !selected,
				            handler: function() { },
				            menu:
				            {
				            	items: [
			            		{
						            text: 'Linecolor',
						            iconCls:'linecolor-icon',
						            menu: lineColorMenu
						        },
						        '-',
						        {
						            text:'Dashed',
						            scope:this,
						            handler: function()
						            {
						                graph.toggleCellStyles(mxConstants.STYLE_DASHED);
						            }
						        },
								{
						            text: 'Linewidth',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_STROKEWIDTH] || 1;
						            	}
	
					            		value = mxUtils.prompt('Enter Linewidth (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_STROKEWIDTH, value);
							            }
						            }
						        }]
				            }
			            },
		            	{
		            		text:'Connector',
		            		menu:
		            		{
		            			items: [
		            			{
						            text: 'Straight',
						            icon: 'images/straight.gif',
						            handler: function()
						            {
						            	graph.setCellStyle('straight');
						            }
						        },
						        '-',
						        {
						            text: 'Horizontal',
						            icon: 'images/connect.gif',
						            handler: function()
						            {
						            	graph.setCellStyle(null);
						            }
						        },
						        {
						            text: 'Vertical',
						            icon: 'images/vertical.gif',
						            handler: function()
						            {
						            	graph.setCellStyle('vertical');
						            }
						        },
						        '-',
						        {
						            text: 'Entity Relation',
						           	icon: 'images/entity.gif',
						            handler: function()
						            {
						            	graph.setCellStyle('edgeStyle=mxEdgeStyle.EntityRelation');
						            }
						        },
						        {
						            text: 'Arrow',
						            icon: 'images/arrow.gif',
						            handler: function()
						            {
						            	graph.setCellStyle('arrow');
						            }
						        },
						        '-',
						        {
						            text: 'Plain',
						            handler: function()
						            {
						        		graph.toggleCellStyles(mxConstants.STYLE_NOEDGESTYLE, false);
						            }
						        }]
		            		}
		            	},
				        '-',
		            	{
							text:'Linestart',
							menu:
							{
		            			items: [
		            			{
		            				text: 'Open',
						            icon: 'images/open_start.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_OPEN);
						            }
						        },
						        {
						            text: 'Classic',
						            icon: 'images/classic_start.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_CLASSIC);
						            }
						        },
						        {
						            text: 'Block',
						            icon: 'images/block_start.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_BLOCK);
						            }
						        },
						        '-',
						        {
						            text: 'Diamond',
						            icon: 'images/diamond_start.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_DIAMOND);
						            }
						        },
						        {
						            text: 'Oval',
						            icon: 'images/oval_start.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.ARROW_OVAL);
						            }
						        },
						        '-',
				                {
						            text: 'None',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_STARTARROW, mxConstants.NONE);
						            }
						        },
				                {
						            text: 'Size',
						            handler: function()
						            {
						            	var size = mxUtils.prompt('Enter Size', mxConstants.DEFAULT_MARKERSIZE);
						            	
						            	if (size != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_STARTSIZE, size);
							            }
						            }
				                }]
							}
						},
						{
							text:'Lineend',
							menu:
							{
								items: [
								{
						            text: 'Open',
						            icon: 'images/open_end.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OPEN);
						            }
						        },
						        {
						            text: 'Classic',
						            icon: 'images/classic_end.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
						            }
						        },
						        {
						            text: 'Block',
						            icon: 'images/block_end.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_BLOCK);
						            }
						        },
						        '-',
						        {
						            text: 'Diamond',
						            icon: 'images/diamond_end.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_DIAMOND);
						            }
						        },
						        {
						            text: 'Oval',
						            icon: 'images/oval_end.gif',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_OVAL);
						            }
						        },
						        '-',
				                {
						            text: 'None',
						            handler: function()
						            {
						            	graph.setCellStyles(mxConstants.STYLE_ENDARROW, 'none');
						            }
				                },
				                {
				                	text: 'Size',
				                	handler: function()
						            {
						            	var size = mxUtils.prompt('Enter Size', mxConstants.DEFAULT_MARKERSIZE);
						            	
						            	if (size != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_ENDSIZE, size);
							            }
						            }
						        }]
							}
						},
						'-',
						{
							text:'Spacing',
							menu:
							{
				                items: [
							    {
						            text: 'Top',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SPACING_TOP] || value;
						            	}

					            		value = mxUtils.prompt('Enter Top Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SPACING_TOP, value);
							            }
						            }
						        },
						        {
						            text: 'Right',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SPACING_RIGHT] || value;
						            	}

					            		value = mxUtils.prompt('Enter Right Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SPACING_RIGHT, value);
							            }
						            }
						        },
						        {
						            text: 'Bottom',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SPACING_BOTTOM] || value;
						            	}

					            		value = mxUtils.prompt('Enter Bottom Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SPACING_BOTTOM, value);
							            }
						            }
						        },
						        {
						            text: 'Left',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SPACING_LEFT] || value;
						            	}

					            		value = mxUtils.prompt('Enter Left Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SPACING_LEFT, value);
							            }
						            }
						        },
						        '-',
				                {
						            text: 'Global',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SPACING] || value;
						            	}

					            		value = mxUtils.prompt('Enter Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SPACING, value);
							            }
						            }
				                },
				                '-',
						        {
						            text: 'Source spacing',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_SOURCE_PERIMETER_SPACING] || value;
						            	}
	
					            		value = mxUtils.prompt('Enter source spacing (pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_SOURCE_PERIMETER_SPACING, value);
							            }
						            }
						        },
								{
						            text: 'Target spacing',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_TARGET_PERIMETER_SPACING] || value;
						            	}
	
					            		value = mxUtils.prompt('Enter target spacing (pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_TARGET_PERIMETER_SPACING, value);
							            }
						            }
						        },
						        '-',
						        {
						            text: 'Perimeter',
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_PERIMETER_SPACING] || value;
						            	}

					            		value = mxUtils.prompt('Enter Perimeter Spacing (Pixels)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_PERIMETER_SPACING, value);
							            }
						            }
						        }]
							}
						},
						{
							text:'Direction',
							menu:
							{
				                items: [
				                {
						            text: 'North',
						            scope:this,
						            handler: function()
						            {
						                graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_NORTH);
						            }
						        },
						        {
						            text: 'East',
						            scope:this,
						            handler: function()
						            {
						                graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_EAST);
						            }
						        },
						        {
						            text: 'South',
						            scope:this,
						            handler: function()
						            {
						                graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_SOUTH);
						            }
						        },
						        {
						            text: 'West',
						            scope:this,
						            handler: function()
						            {
						                graph.setCellStyles(mxConstants.STYLE_DIRECTION, mxConstants.DIRECTION_WEST);
						            }
						        },
						        '-',
						        {
						            text:'Rotation',
						            scope:this,
						            handler: function()
						            {
						            	var value = '0';
						            	var state = graph.getView().getState(graph.getSelectionCell());
						            	
						            	if (state != null)
						            	{
						            		value = state.style[mxConstants.STYLE_ROTATION] || value;
						            	}

					            		value = mxUtils.prompt('Enter Angle (0-360)', value);
							            	
						            	if (value != null)
						            	{
							            	graph.setCellStyles(mxConstants.STYLE_ROTATION, value);
							            }
						            }
						        }]
							}
						},
				        '-',
				        {
				            text:'Rounded',
				            scope:this,
				            handler: function()
				            {
				               graph.toggleCellStyles(mxConstants.STYLE_ROUNDED);
				            }
				        },
				       	{
				            text:'Style',
				            scope:this,
				            handler: function()
				            {
				        		var cells = graph.getSelectionCells();

								if (cells != null &&
									cells.length > 0)
								{
									var model = graph.getModel();
									var style = mxUtils.prompt('Enter Style', model.getStyle(cells[0]) || '');
				
									if (style != null)
									{
										graph.setCellStyle(style, cells);
									}
								}
				            }
				        }]
		            }
              	},
              	{
              		split:true,
		            text:'Shape',
		            handler: function() { },
		            menu:
		            {
		                items: [
		                {
		                    text:'Home',
		                    iconCls: 'home-icon',
		                    disabled: graph.view.currentRoot == null,
		                    scope: this,
		                    handler:function()
		                    {
		                    	graph.home();
		                    }
		              	},
		              	'-',
		                {
		                    text:'Exit group',
		                    iconCls:'up-icon',
		                    disabled: graph.view.currentRoot == null,
		                    scope: this,
		                    handler:function()
		                    {
		                    	graph.exitGroup();
		                    }
		              	},
		                {
		                    text:'Enter group',
		                    iconCls:'down-icon',
		                    disabled: !selected,
		                    scope: this,
		                    handler:function()
		                    {
		                    	graph.enterGroup();
		                    }
		              	},
				        '-',
                        {
				            text:'Group',
				            icon: 'images/group.gif',
				            disabled: graph.getSelectionCount() <= 1,
				            scope:this,
				            handler: function()
				            {
				                graph.setSelectionCell(graph.groupCells(null, 20));
				            }
				        },
				        {
				            text:'Ungroup',
				            icon: 'images/ungroup.gif',
				            scope:this,
				            handler: function()
				            {
				        		graph.setSelectionCells(graph.ungroupCells());
				            }
				        },
				        '-',
				       	{
				            text:'Remove from group',
				            scope:this,
				            handler: function()
				            {
				                graph.removeCellsFromParent();
				            }
				        },
		              	'-',
						{
		                    text:'Collapse',
		                    iconCls:'collapse-icon',
		                    disabled: !selected,
		                    scope: this,
		                    handler:function()
		                    {
		                    	graph.foldCells(true);
		                    }
		              	},
		                {
		                    text:'Expand',
		                    iconCls:'expand-icon',
		                    disabled: !selected,
		                    scope: this,
		                    handler:function()
		                    {
		                    	graph.foldCells(false);
		                    }
		              	},
		              	'-',
		                {
				            text:'To Back',
				            icon: 'images/toback.gif',
				            scope:this,
				            handler: function()
				            {
				                graph.orderCells(true);
				            }
				        },
				        {
				            text:'To Front',
				            icon: 'images/tofront.gif',
				            scope:this,
				            handler: function()
				            {
				                graph.orderCells(false);
				            }
				        },
				        '-',
				        
				        
				        {
							text:'Align',
							menu:
							{
								items: [
								{
						            text: 'Left',
						            icon: 'images/alignleft.gif',
						            handler: function()
						            {
										graph.alignCells(mxConstants.ALIGN_LEFT);
						            }
						        },
						        {
						            text: 'Center',
						            icon: 'images/aligncenter.gif',
						            handler: function()
						            {
						        		graph.alignCells(mxConstants.ALIGN_CENTER);
						            }
						        },
						        {
						            text: 'Right',
						            icon: 'images/alignright.gif',
						            handler: function()
						            {
						        		graph.alignCells(mxConstants.ALIGN_RIGHT);
						            }
						        },
						        '-',
						        {
						            text: 'Top',
						            icon: 'images/aligntop.gif',
						            handler: function()
						            {
						        		graph.alignCells(mxConstants.ALIGN_TOP);
						            }
						        },
						        {
						            text: 'Middle',
						            icon: 'images/alignmiddle.gif',
						            handler: function()
						            {
						        		graph.alignCells(mxConstants.ALIGN_MIDDLE);
						            }
						        },
						        {
						            text: 'Bottom',
						            icon: 'images/alignbottom.gif',
						            handler: function()
						            {
						        		graph.alignCells(mxConstants.ALIGN_BOTTOM);
						            }
						        }]
							}
						},
				        '-',
				       	{
				            text:'Autosize',
				            scope:this,
				            handler: function()
				            {
				            	if (!graph.isSelectionEmpty())
				            	{
				            		graph.updateCellSize(graph.getSelectionCell());
				            	}
				            }
				        }]
		            }
			    },
			    '-',
		       	{
		            text:'Edit',
		            scope:this,
		            handler: function()
		            {
		                graph.startEditing();
		            }
		        },
			    '-',
                {
                    text:'Select Vertices',
                    scope: this,
                    handler:function()
                    {
			    		graph.selectVertices();
                    }
              	},
              	{
                    text:'Select Edges',
                    scope: this,
                    handler:function()
                    {
              			graph.selectEdges();
                    }
              	},
              	'-',
              	{
                    text:'Select All',
                    scope: this,
                    handler:function()
                    {
                    	graph.selectAll();
                    }
              	}]
            });
	            
            this.menu.on('hide', this.onContextHide, this);
            this.menu.showAt([e.clientX, e.clientY]);
	    },
	
	    onContextHide : function()
	    {
	        if(this.ctxNode)
	        {
	            this.ctxNode.ui.removeClass('x-node-ctx');
	            this.ctxNode = null;
	        }
	    }
    });

    MainPanel.superclass.constructor.call(this,
    {
        region:'center',
        layout: 'fit',
        items: this.graphPanel
    });

    // Redirects the context menu to ExtJs menus
    var self = this; // closure
    graph.panningHandler.popup = function(x, y, cell, evt)
    {
    	self.graphPanel.onContextMenu(null, evt);
    };

    graph.panningHandler.hideMenu = function()
    {
		if (self.graphPanel.menuPanel != null)
    	{
			self.graphPanel.menuPanel.hide();
    	}
    };

    // Fits the SVG container into the panel body
    this.graphPanel.on('resize', function()
    {
        graph.sizeDidChange();
    });
};

Ext.extend(MainPanel, Ext.Panel);
