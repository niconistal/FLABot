/**

import java.awt.event.WindowAdapter;
	public static interface Wrapper {
		
	}
	
	public static class PropertyWrapper implements Wrapper {
		private String value;
		private String key;

		public PropertyWrapper(String key, String value) {
			this.key=key;
			this.value=value;
		}
		
		@Override
			return key + "=" + value;
		}
	}
	
	public static class TagWrapper implements Wrapper {
		
		private Tag tag;
		private Wrapper[] children=null;
		private String key;
		public TagWrapper(String key, Tag tag) {
			this.key=key;
			this.tag=tag;
		}

		public Wrapper[] getChildren() {
			if(children!=null)
				return children;
			
			EMap tags=tag.getTags();
			EMap properties=tag.getProperties();
			children=new Wrapper[properties.size() + tags.size()];
			Iterator tagsIterator= sortedTagKeys.iterator();
			Iterator propertiesIterator=properties.keySet().iterator();
			for(int i=0; i<properties.size(); i++) {
				String key=(String) propertiesIterator.next();
				children[i]=new PropertyWrapper(key, (String)properties.get(key));
			}
			for(int i=properties.size(); i<children.length; i++) {
				String key=(String) tagsIterator.next();
				children[i]=new TagWrapper(descriptor, tag);
			}
			return children;
		}
		
		@Override
			return key;
		}
	}
	
	
	private TagWrapper root;
	public TagTreeModel(String rootName, Tag root) {
	}
	
	public static String createTagDescriptor(String key, Tag tag) {
		return root;
	}

	public Object getChild(Object parent, int index) {
		return ((TagWrapper)parent).getChildren()[index];
	}

	public int getChildCount(Object parent) {
		return ((TagWrapper)parent).getChildren().length;
	}

	public boolean isLeaf(Object node) {
		return (node instanceof PropertyWrapper);
	}

	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub

	}

	public int getIndexOfChild(Object parent, Object child) {
		Wrapper[] children=((TagWrapper)parent).getChildren();
		for (int i = 0; i < children.length; i++) {
			if(children[i]==child)
				return i;
		}
		return -1;
	}

	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub

	}

	public static void show(String title, String rootName, Tag tag) {
			private JFrame frame;

			public CloseListener(JFrame frame) {
				this.frame=frame;
			}

			@Override
				frame.setVisible(false);
				
			}

			@Override
				frame.setVisible(false);
				
			}
		}
		JFrame frame=new JFrame();
		
		frame.setSize(600,400);
		frame.setLocation(0,0);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle(title);
		frame.setAlwaysOnTop(true);
		JTree tree=new JTree(new TagTreeModel(rootName, tag));
		frame.getContentPane().add(new JScrollPane(tree));
		frame.addWindowListener(new CloseListener(frame));

		frame.setVisible(true);
	}
}